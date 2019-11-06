package iamutkarshtiwari.github.io.ananas.editimage.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import iamutkarshtiwari.github.io.ananas.R;
import iamutkarshtiwari.github.io.ananas.editimage.ModuleConfig;
import iamutkarshtiwari.github.io.ananas.editimage.fragment.paint.PaintFragment;


public class MainMenuFragment extends BaseEditFragment implements View.OnClickListener {
    public static final int INDEX = ModuleConfig.INDEX_MAIN;

    public static final String TAG = MainMenuFragment.class.getName();
    private View mainView;

    private View stickerBtn;
    private View fliterBtn;
    private View mTextBtn;
    private View mPaintBtn;
    private View mEmoteBtn;

    public static MainMenuFragment newInstance() {
        MainMenuFragment fragment = new MainMenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_edit_image_main_menu,
                null);
        return mainView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fliterBtn = mainView.findViewById(R.id.btn_filter);
        mPaintBtn = mainView.findViewById(R.id.btn_paint);
        stickerBtn = mainView.findViewById(R.id.btn_stickers);
        mTextBtn = mainView.findViewById(R.id.btn_text);
        mEmoteBtn = mainView.findViewById(R.id.btn_crop);

        fliterBtn.setOnClickListener(this);
        mPaintBtn.setOnClickListener(this);
        mEmoteBtn.setOnClickListener(this);
        stickerBtn.setOnClickListener(this);
        mTextBtn.setOnClickListener(this);
    }

    @Override
    public void onShow() {
        // do nothing
    }

    @Override
    public void backToMain() {
        //do nothing
    }

    @Override
    public void onClick(View v) {

        if (v == fliterBtn) {
            onFilterClick();
        } else if (v == mPaintBtn) {
            onPaintClick();
        } else if (v == stickerBtn) {
            onStickClick();
        } else if (v == mTextBtn) {
            onAddTextClick();
        } else if (v == mEmoteBtn){
            onEmoteClick();
        }
    }

    private void onFilterClick() {
        activity.bottomGallery.setCurrentItem(FilterListFragment.INDEX);
        activity.filterListFragment.onShow();
    }

    private void onPaintClick() {
        activity.bottomGallery.setCurrentItem(PaintFragment.INDEX);
        activity.paintFragment.onShow();
    }

    private void onStickClick() {
        activity.bottomGallery.setCurrentItem(StickerFragment.INDEX);
        activity.stickerFragment.onShow();
        activity.stickerFragment.swipToStickerDetails("stkr_moove", 21);
    }

    private void onAddTextClick() {
        activity.bottomGallery.setCurrentItem(AddTextFragment.INDEX);
        activity.addTextFragment.onShow();
    }

    private void onEmoteClick() {
        activity.bottomGallery.setCurrentItem(StickerFragment.INDEX);
        activity.stickerFragment.onShow();
        activity.stickerFragment.swipToStickerDetails("emote_moove", 20);
    }
}
