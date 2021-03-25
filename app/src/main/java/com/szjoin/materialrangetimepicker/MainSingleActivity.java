package com.szjoin.materialrangetimepicker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

/**
 * 创建人：MyDream
 * 创建日期：2021/03/25 15:56
 * 类描述：
 */
public class MainSingleActivity extends AppCompatActivity {
    ViewPager viewPager;
    PickerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_layout);
        adapter = new PickerAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        for(int i=0; i < adapter.getCount(); i++) //noinspection ConstantConditions
            tabLayout.getTabAt(i).setText(adapter.getTitle(i));
    }

    private class PickerAdapter extends FragmentPagerAdapter {
        private static final int NUM_PAGES = 2;
        Fragment timePickerFragment;
        Fragment datePickerFragment;

        PickerAdapter(FragmentManager fm) {
            super(fm);
            timePickerFragment = new TimePickerFragment();
            datePickerFragment = new DatePickerFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    return timePickerFragment;
                case 1:
                default:
                    return datePickerFragment;
            }
        }

        int getTitle(int position) {
            switch(position) {
                case 0:
                    return R.string.tab_title_time;
                case 1:
                default:
                    return R.string.tab_title_date;
            }
        }
    }
}
