package com.project.base.view.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.base.R;
import com.project.base.presenter.base.activity.BaseActivity;
import com.project.base.presenter.base.session.PersonalData;
import com.project.base.presenter.callback.CallbackFragment;
import com.project.base.presenter.custom.typeface.TypeFaceTitle;
import com.project.base.view.fragment.HomeFragment_;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

@EActivity(R.layout.activity_navigation)
public class NavigationActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, CallbackFragment {

    @ViewById protected Toolbar toolbar;
    @ViewById(R.id.drawer_layout) protected DrawerLayout drawer;
    @ViewById(R.id.nav_view) protected NavigationView navigationView;
    @StringRes(R.string.app_name) protected String nameApp;

    View header;
    private ImageView imageProfile;
    private TextView name;
    private TextView userType;

    @AfterViews
    protected void init() {
        setToolbar();
        setNavigationDrawer();
        setDataNav();
        idFrame = R.id.main_frame;
        homeMenu();
    }

    private void setDataNav() {
        header = navigationView.getHeaderView(0);
        imageProfile = (ImageView) header.findViewById(R.id.imageProfile);
        name = (TextView) header.findViewById(R.id.name);
        userType = (TextView) header.findViewById(R.id.userType);

        PersonalData personalData = new PersonalData(this);
        Picasso.with(this).load(personalData.getProfPic()).into(imageProfile);
        //name.setText(personalData.getNameUser());
        //userType.setText(personalData.getTeam());

        setFontNavigationItem();
    }

    private void setFontNavigationItem() {
        Menu menu = navigationView.getMenu();
        for (int pos = 0; pos < menu.size(); pos++) {
            MenuItem menuItem = menu.getItem(pos);
            setTypeFaceMenuItem(menuItem);
            SubMenu subMenu = menuItem.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int position = 0; position < subMenu.size(); position++) {
                    MenuItem subMenuItem = subMenu.getItem(position);
                    setTypeFaceMenuItem(subMenuItem);
                }
            }
        }
    }

    private void setTypeFaceMenuItem(MenuItem menuItem) {
        SpannableString spannableString = new SpannableString(menuItem.getTitle());
        spannableString.setSpan(new TypeFaceTitle(this, "Lato-Regular.ttf"), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        menuItem.setTitle(spannableString);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            if (requestCode == IntentManager.Code.REQUEST_CAMERA) {
//                IntentManager.setProfpic(data, imageProfile, IntentManager.Code.BACKGROUND, getResources(), NavigationActivity.this);
//                //refreshFragment();
//            }
//        }
//    }

    @Override
    public void homeMenu() {
        fragmentShowMain(HomeFragment_.builder().build());
    }

    public void fragmentShowMain(Fragment fragment) {
        showFragment(idFrame, fragment, false, null);
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        SpannableString s = new SpannableString(nameApp);
        s.setSpan(new TypeFaceTitle(this, "Lato-Regular.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(s);
    }

    private void setNavigationDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fragmentShowMain(HomeFragment_.builder().build());
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
