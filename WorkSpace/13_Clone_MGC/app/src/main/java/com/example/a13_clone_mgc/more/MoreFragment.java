package com.example.a13_clone_mgc.more;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a13_clone_mgc.R;
import com.example.a13_clone_mgc.card.CardFragment;
import com.example.a13_clone_mgc.databinding.FragmentMoreBinding;
import com.example.a13_clone_mgc.main.CouponActivity;
import com.example.a13_clone_mgc.main.StampActivity;
import com.example.a13_clone_mgc.order.OrderFragment;
import com.example.a13_clone_mgc.present.PresentFragment;
import com.example.a13_clone_mgc.present.PresentMainFragment;

public class MoreFragment extends Fragment implements View.OnClickListener {

    private FragmentMoreBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMoreBinding.inflate(inflater,container,false);
        View v = binding.getRoot();
        //프래그먼트에서의 뷰바인딩 사용 방법
        //https://developer.android.com/topic/libraries/view-binding?hl=ko#java

        binding.tvStamp.setOnClickListener(this);
        binding.tvCoupon.setOnClickListener(this);
        binding.tvMegaorder.setOnClickListener(this);
        binding.tvOrderHistory.setOnClickListener(this);
        binding.tvPresent.setOnClickListener(this);
        binding.tvCard.setOnClickListener(this);
        binding.tvEasyCard.setOnClickListener(this);
        binding.tvBuyCoupon.setOnClickListener(this);
        binding.tvEvent.setOnClickListener(this);
        binding.tvNotice.setOnClickListener(this);
        binding.tvPolicy.setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {
        if( v.getId() == R.id.tv_stamp ) {
            Intent intent = new Intent(getContext(), StampActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);
        } else if ( v.getId() == R.id.tv_coupon ) {
            Intent intent = new Intent(getContext(), CouponActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);
        } else if ( v.getId() == R.id.tv_megaorder ) {
            getParentFragmentManager().beginTransaction().replace(R.id.container,new OrderFragment()).commit();
        } else if ( v.getId() == R.id.tv_order_history ) {
            Intent intent = new Intent(getContext(), OrderHistoryActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);
        } else if ( v.getId() == R.id.tv_present ) {
            getParentFragmentManager().beginTransaction().replace(R.id.container,new PresentFragment()).commit();
        } else if ( v.getId() == R.id.tv_card ) {
            getParentFragmentManager().beginTransaction().replace(R.id.container,new CardFragment()).commit();
        } else if ( v.getId() == R.id.tv_easy_card ) {
            Intent intent = new Intent(getContext(), EasyCardActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);
        } else if ( v.getId() == R.id.tv_buy_coupon ) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://event.multicon.co.kr/survey/megacoffee_b2b?pid=8TuBJm%2BA4%2BtzUkTTXbdi3w%3D%3D&curr_time=1671621043&uid=7837218040720365"));
            startActivity(intent);
        } else if ( v.getId() == R.id.tv_event ) {

        } else if ( v.getId() == R.id.tv_notice ) {

        } else if ( v.getId() == R.id.tv_policy ) {
            Intent intent = new Intent(getContext(), PolicyActivity.class);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.in_to_left,R.anim.in_from_right);
        }

    }
}