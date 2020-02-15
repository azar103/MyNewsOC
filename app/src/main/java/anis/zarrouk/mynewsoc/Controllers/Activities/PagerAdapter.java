package anis.zarrouk.mynewsoc.Controllers.Activities;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import anis.zarrouk.mynewsoc.Controllers.Fragments.BusinessFragment;
import anis.zarrouk.mynewsoc.Controllers.Fragments.MostPopularFragment;
import anis.zarrouk.mynewsoc.Controllers.Fragments.SportsFragment;
import anis.zarrouk.mynewsoc.Controllers.Fragments.TopStoriesFragment;

/*
 * Created by Anis Zarrouk on 14/02/2020
 */public class PagerAdapter extends FragmentPagerAdapter {

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case  0:
                return TopStoriesFragment.newInstance();
            case  1:
                return MostPopularFragment.newInstance();
            case 2:
                return BusinessFragment.newInstance();
            case 3:
                return SportsFragment.newInstance();
            default:
                return  null;
        }

    }


    public PagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return (4);
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return  "Top Stories";
            case 1:
                return  "Most Popular";
            case 2:
                return  "Business";
            case  3:
                return  "Sports";
            default:
                return null;
        }
    }
}
