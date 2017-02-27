package com.example.dingchen.youkumenu;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RelativeLayout rl_level1;
    private RelativeLayout rl_level2;
    private RelativeLayout rl_level3;
    boolean islevel1 = true;
    boolean islevel2 = true;
    boolean islevel3 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initViews();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(AnimationUtils.runningAnimationCount>0){

            return true;
        }

        if(keyCode == KeyEvent.KEYCODE_MENU){
            if(islevel1){
                long delay =0;
                if(islevel3){
                    AnimationUtils.rotateOutAnim(rl_level3,0);
                    islevel3 = false;
                    delay+=200;
                }

                if(islevel2){
                    AnimationUtils.rotateOutAnim(rl_level3,delay);
                    islevel2 = false;
                    delay+=200;
                }
                AnimationUtils.rotateOutAnim(rl_level1,delay);
            }else{
                AnimationUtils.rotateInAnim(rl_level1,0);
                AnimationUtils.rotateInAnim(rl_level2,200);
                AnimationUtils.rotateInAnim(rl_level3,400);
                islevel2 = true;
                islevel3 = true;
            }
            islevel1 = !islevel1;
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initViews() {
        findViewById(R.id.ib_home).setOnClickListener(this);
        findViewById(R.id.ib_menu).setOnClickListener(this);
        rl_level1 = (RelativeLayout)findViewById(R.id.rl_level1);
        rl_level2 = (RelativeLayout)findViewById(R.id.rl_level2);
        rl_level3 = (RelativeLayout)findViewById(R.id.rl_level3);
    }

    @Override
    public void onClick(View v) {
        if(AnimationUtils.runningAnimationCount>0){

            return;
        }
        switch(v.getId()){
            case R.id.ib_home:

                if(islevel2){
                    long delay = 0;
                    if(islevel3){

                        AnimationUtils.rotateOutAnim( rl_level3,0);
                        islevel3 = false;
                        delay += 200;
                    }
                    AnimationUtils.rotateOutAnim( rl_level2,delay);
                    islevel2 = false;
                }else{
                    AnimationUtils.rotateInAnim( rl_level2,0);
                    islevel2 = true;
                }
                break;
            case R.id.ib_menu:
                if(islevel3){
                    AnimationUtils.rotateOutAnim( rl_level3,0);
                    islevel3 = false;
                }else{
                    AnimationUtils.rotateInAnim( rl_level3,0);
                    islevel3 = true;
                }
                break;

            default:
                break;
        }
    }
}
