package com.xploreict.simofferbd;

import android.content.Intent;
import android.graphics.Color;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Add your slide fragments here.

        // AppIntro will automatically generate the dots indicator and buttons.
//        addSlide(firstFragment);
//        addSlide(secondFragment);
//        addSlide(thirdFragment);
//        addSlide(fourthFragment);


        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.


        SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle("Grammenphone!");
        sliderPage.setDescription("The easiest way to buy voice, Internet and Facebook package!");
        sliderPage.setImageDrawable(R.drawable.g);
        sliderPage.setBgColor(getResources().getColor(R.color.txt_color_black));


        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("Airtel!");
        sliderPage2.setDescription("The easiest way to buy voice, Internet and Facebook package!");
        sliderPage2.setImageDrawable(R.drawable.a);
        sliderPage2.setBgColor(getResources().getColor(R.color.txt_color_black));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("Robi!");
        sliderPage3.setDescription("The easiest way to buy voice, Internet and Facebook package!");
        sliderPage3.setImageDrawable(R.drawable.r);
        sliderPage3.setBgColor(getResources().getColor(R.color.txt_color_black));

        SliderPage sliderPage4 = new SliderPage();
        sliderPage4.setTitle("Banglalink!");
        sliderPage4.setDescription("The easiest way to buy voice, Internet and Facebook package!");
        sliderPage4.setImageDrawable(R.drawable.b);
        sliderPage4.setBgColor(getResources().getColor(R.color.txt_color_black));

        SliderPage sliderPage5 = new SliderPage();
        sliderPage5.setTitle("Teletalk!");
        sliderPage5.setDescription("The easiest way to buy voice, Internet and Facebook package!");
        sliderPage5.setImageDrawable(R.drawable.t);
        sliderPage5.setBgColor(getResources().getColor(R.color.txt_color_black));

        addSlide(AppIntroFragment.newInstance(sliderPage));
        addSlide(AppIntroFragment.newInstance(sliderPage2));
        addSlide(AppIntroFragment.newInstance(sliderPage3));
        addSlide(AppIntroFragment.newInstance(sliderPage4));
        addSlide(AppIntroFragment.newInstance(sliderPage5));


        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);


        setFadeAnimation();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent i = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        finish();
    }

}
