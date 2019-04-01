package tdt.com.tabbar_demo;


import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SearchView txtSearchWord;
    private Button btnGreenActi;
    private  Button btnRedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handleEvent();
        setUpActionBar();

    }

    private void handleEvent() {
        btnGreenActi.setOnClickListener(this);
        btnRedFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        switch (id){
            case R.id.btnGreenActivity: {
                Intent greenActivityIntent = new Intent(MainActivity.this,GreenActivity.class);
                //put data items inside the bundle
                Bundle dataInfo = new Bundle();
                greenActivityIntent.putExtra("data",dataInfo);
                startActivityForResult(greenActivityIntent,0);
            }
            case R.id.btnRedButton :{
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                RedFragment fragment = RedFragment.newInstance("new-frag-args1");
                fragmentTransaction.replace(R.id.frag_container_inside_main,fragment,"red_frag");
                fragmentTransaction.addToBackStack("red_tran"); //allows back button pop-navigation
                fragmentTransaction.commit();            }
        }

    }

    private void initView() {
        btnGreenActi = findViewById(R.id.btnGreenActivity);
        btnRedFragment = findViewById(R.id.btnRedButton);
        

    }

    private void setUpActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("RainbowTalk");

        //choose type of background
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_actionbar));
        /*actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);*/

        actionBar.setDisplayOptions(  ActionBar.DISPLAY_SHOW_TITLE
                                    | ActionBar.DISPLAY_SHOW_HOME
                                    | ActionBar.DISPLAY_HOME_AS_UP
                                    | ActionBar.DISPLAY_SHOW_CUSTOM);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        //get access to collapsible SearchView
        MenuItem searchItem = menu.findItem(R.id.action_search);
        txtSearchWord = (SearchView) searchItem.getActionView();
        //set SearchView listener (text change)
        txtSearchWord.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //show toast
                Toast.makeText(getApplicationContext(), "Search: "+ s, Toast.LENGTH_LONG).show();
                //close current searchview and re-draws action bar
                invalidateOptionsMenu();
                //clear text
                txtSearchWord.setQuery("",false);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_search){
            Toast.makeText(this, "Search menu", Toast.LENGTH_LONG).show();
            return  true;
        }else if(id == R.id.action_add_conatct){
            Toast.makeText(this, "action_add_conatct menu", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(id == R.id.about){
            Toast.makeText(this, "about", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(id == R.id.setting){
            Toast.makeText(this, "setting menu", Toast.LENGTH_LONG).show();
            return  true;
        }
        else if(id == R.id.action_search){
            Toast.makeText(this, "Search menu", Toast.LENGTH_LONG).show();
            return  true;
        }
        return false;
    }
}
