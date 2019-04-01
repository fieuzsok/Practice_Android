package tdt.com.tabbar_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class RedFragment extends Fragment {
    private TextView txtMsgRedFrag;
    public  static RedFragment newInstance(String strArgs){
        RedFragment redFragment =  new RedFragment();
        Bundle agrs = new Bundle();
        agrs.putString("strArg1",strArgs);
        redFragment.setArguments(agrs);
        return redFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu((true));

        //enable home button
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout redLayout = (LinearLayout) inflater.inflate(R.layout.fragment_red,null);
        txtMsgRedFrag = redLayout.findViewById(R.id.txtMsgFrag);
        final Button btnGetDate = redLayout.findViewById(R.id.btnDate_red_frag);
        btnGetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = (new Date()).toString();
                txtMsgRedFrag.setText(txt);
            }
        });
        return  redLayout;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.red_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:{
                txtMsgRedFrag.setText("ActionID: " + id);
                //clearBackStack(); //jump to mainActivity
                showPreviousRedScreen();
            }

            default:
                txtMsgRedFrag.setText("ActionID: " + id);
        }
        return super.onOptionsItemSelected(item);
    }

    private void showPreviousRedScreen() {
        try {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            FragmentManager fragmentManager = getFragmentManager();

            //detemine size n of the backstack (0,1,..n-1)
            int backStackCount = fragmentManager.getBackStackEntryCount();

            //
            FragmentManager.BackStackEntry topEntry = fragmentManager.getBackStackEntryAt(backStackCount - 1);

            String tag = topEntry.getName();
            int id = topEntry.getId();
            Log.e("RED top fragment name: ", tag + " " + id);
            fragmentManager.popBackStackImmediate();
            fragmentTransaction.commit();
        }catch (Exception e){
            Log.e("REMOVE >>>" , e.getMessage());
        }
    }

    private void clearBackStack() {
        try{
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.popBackStackImmediate(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.commit();
        }catch (Exception e){
            Log.e("CLEAR STACK", e.getMessage());
        }
    }
}
