package net.tomlins.viewpagerexample.adaptor;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import net.tomlins.viewpagerexample.app.R;

import static java.lang.Class.forName;

/**
 * Created by jason on 26/05/14.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public static final String TAG = "TabsPagerAdapter";
    private String[] sFragments;

    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        Resources res = context.getResources();
        sFragments = res.getStringArray(R.array.fragment_clazzez);
    }

    @Override
    public Fragment getItem(int position) {
        try {
            Log.i(TAG, "Returning new instance of " + sFragments[position]);
            return (Fragment) forName(sFragments[position]).newInstance();
        }
        catch (Exception x) {
        }
        return null;
    }

    @Override
    public int getCount() {
        return sFragments.length;
    }
}
