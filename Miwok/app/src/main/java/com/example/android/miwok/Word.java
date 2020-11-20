package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation,mMiowkTranslation;
    private static final int NO_IMAGE_ID=-1;
    private int mImageResourcesId;
    private  int mSoundResourcesId;

    public Word(String defaultTranslation,String MiowkTranslation,int ImageResourcesId,int SoundResourcesId){
        this.mDefaultTranslation=defaultTranslation;
        this.mMiowkTranslation=MiowkTranslation;
        this.mImageResourcesId=ImageResourcesId;
        this.mSoundResourcesId=SoundResourcesId;
    }
    public Word(String defaultTranslation,String MiowkTranslation,int SoundResourcesId){
        this.mDefaultTranslation=defaultTranslation;
        this.mMiowkTranslation=MiowkTranslation;
        this.mSoundResourcesId=SoundResourcesId;
    }



    public int getmImageResourcesId() {
        return mImageResourcesId;
    }

    public boolean hasImages(){
        return  getmImageResourcesId()!=NO_IMAGE_ID;
    }

    public  String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiowkTranslation(){
        return mMiowkTranslation;
    }
    public  int getmSoundResourcesId(){return  mSoundResourcesId;}

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiowkTranslation='" + mMiowkTranslation + '\'' +
                ", mImageResourcesId=" + mImageResourcesId +
                ", mSoundResourcesId=" + mSoundResourcesId +
                '}';
    }
}
