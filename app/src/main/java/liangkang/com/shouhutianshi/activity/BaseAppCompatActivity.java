package liangkang.com.shouhutianshi.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import liangkang.com.shouhutianshi.R;
import liangkang.com.shouhutianshi.utils.LoadingDialog;
import liangkang.com.shouhutianshi.utils.SysUitils;







/**
 * Created by luying on 16/6/15.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity implements View.OnClickListener {




    protected String title;
    protected boolean shouldAdjustToolbarToFitWindow = true;
    protected boolean shouldSetUpToolbarBackIcon = true;

    protected Toolbar toolbar;
    protected TextView toolbarTitle;
    public LoadingDialog loadingDialog;

    protected boolean toolbarInitialized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadingDialog = new LoadingDialog(this);
    }

    /**
     * WARNING: load data after onResume, otherwise will lose events
     */
    @Override
    protected void onResume() {
        super.onResume();

        if (!toolbarInitialized) {

            toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbarTitle = (TextView) findViewById(R.id.toolbarTitle);

            if (toolbar != null) {

                if (toolbarTitle != null) {
                    toolbarTitle.setText(title);
                }

                setSupportActionBar(toolbar);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("");
                }

                if (shouldSetUpToolbarBackIcon) {
                    toolbar.setNavigationIcon(R.mipmap.ic_action_back_white60);
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                            overridePendingTransition(R.anim.left_in, R.anim.right_out);
                        }
                    });
                }

                if (shouldAdjustToolbarToFitWindow) {
                    adjustToolbarToFitWindow(toolbar);
                }
            }

            toolbarInitialized = true;
        }
    }

    @Override
    protected void onPause() {


        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
    }

    public void showLoadingDialog(String title) {
        loadingDialog.showDialog(title);
    }

    public void showLoadingDialog() {
        loadingDialog.show();
    }

    public void hideLoadingDialog() {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    private static int sToolbarHeight = 0;

    protected void adjustToolbarToFitWindow(Toolbar toolbar) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();

            if (sToolbarHeight == 0) {
                sToolbarHeight = layoutParams.height;
            }

            toolbar.setPadding(0, SysUitils.getStatusBarHeight(this), 0, 0);
            layoutParams.height = sToolbarHeight + SysUitils.getStatusBarHeight(this);
            toolbar.setLayoutParams(layoutParams);
        }
    }

    public void setToolbarTitle(int toolbarTitleTvId, int titleStrId) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        TextView toolbarTitleTv = (TextView) findViewById(toolbarTitleTvId);
        toolbarTitleTv.setText(getString(titleStrId));
        toolbarTitleTv.setVisibility(View.VISIBLE);
    }


    //****** Android M Permission (Android 6.0权限控制代码封装) ******
    private int permissionRequestCode = 88;
    private PermissionCallback permissionRunnable;

    public interface PermissionCallback {
        void hasPermission();

        void noPermission();
    }

    /**
     * Android M运行时权限请求封装
     *
     * @param permissionDes 权限描述
     * @param runnable      请求权限回调
     * @param permissions   请求的权限（数组类型），直接从Manifest中读取相应的值，比如Manifest.permission.WRITE_CONTACTS
     */
    public void performCodeWithPermission(String permissionDes, PermissionCallback runnable, String... permissions) {
        if (permissions == null || permissions.length == 0) return;
//        this.permissionrequestCode = requestCode;
        this.permissionRunnable = runnable;
        if (checkPermissionGranted(permissions)) {
            if (permissionRunnable != null) {
                permissionRunnable.hasPermission();
                permissionRunnable = null;
            }
        } else {
            //permission has not been granted.
            requestPermission(permissionDes, permissionRequestCode, permissions);
        }

    }

    private boolean checkPermissionGranted(String[] permissions) {
        boolean flag = true;
        for (String p : permissions) {
            if (ActivityCompat.checkSelfPermission(this, p) != PackageManager.PERMISSION_GRANTED) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private void requestPermission(String permissionDes, final int requestCode, final String[] permissions) {
        if (shouldShowRequestPermissionRationale(permissions)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example, if the request has been denied previously.

            //如果用户之前拒绝过此权限，再提示一次准备授权相关权限
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage(permissionDes)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(BaseAppCompatActivity.this, permissions, requestCode);
                        }
                    }).show();

        } else {
            // Contact permissions have not been granted yet. Request them directly.
            ActivityCompat.requestPermissions(BaseAppCompatActivity.this, permissions, requestCode);
        }
    }

    private boolean shouldShowRequestPermissionRationale(String[] permissions) {
        boolean flag = false;
        for (String p : permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, p)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == permissionRequestCode) {
            if (verifyPermissions(grantResults)) {
                if (permissionRunnable != null) {
                    permissionRunnable.hasPermission();
                    permissionRunnable = null;
                }
            } else {
                Toast.makeText(this, "暂无权限执行相关操作！", Toast.LENGTH_SHORT).show();
                if (permissionRunnable != null) {
                    permissionRunnable.noPermission();
                    permissionRunnable = null;
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    public boolean verifyPermissions(int[] grantResults) {
        // At least one result must be checked.
        if (grantResults.length < 1) {
            return false;
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
    //****** END Android M Permission ******

}

