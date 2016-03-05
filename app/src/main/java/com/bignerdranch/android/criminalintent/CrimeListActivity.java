package com.bignerdranch.android.criminalintent;

/**
 * Created by vongr on 3/1/2016.
 */

import android.support.v4.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
