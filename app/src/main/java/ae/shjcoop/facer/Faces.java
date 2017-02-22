package ae.shjcoop.facer;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by faisalkhalid on 2/22/17.
 */

public class Faces extends PagerAdapter {

    public Context mContext;

    private int[] faces = { R.drawable.one , R.drawable.two, R.drawable.three};



    Faces(Context ctx){
        mContext = ctx;

    }
     @Override
    public int getCount() {
        return faces.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
}

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflator.inflate(R.layout.swipebackground,container,false);
        ImageView face = (ImageView) view.findViewById(R.id.face);
        face.setImageResource(faces[position]);

        container.addView(view);
        return view;
    }


}
