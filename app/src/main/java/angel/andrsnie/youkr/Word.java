/*
 * Created by andrSnie on 2.01.20 3:17
 * Copyright (c) 2020. All rights reserved.
 */

package angel.andrsnie.youkr;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains resource IDs for the default translation, Ukr translation, audio file, and
 * optional image file for that word.
 */
class Word {

    /** String resource ID for the default translation of the word */
    private int mDefaultTranslationId;

    /** String resource ID for the Ukr translation of the word */
    private int mYoukrTranslationId;

    /** Image resource ID for the word */
    private int mImageResourceId = -1;
	
	/** Audio resource ID for the word */
    private int mAudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslationId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param youkrTranslationId is the string resource ID for the word in the Ukrainian language
	 *
	 * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    Word(int defaultTranslationId, int youkrTranslationId, int audioResourceId) {
        mDefaultTranslationId = defaultTranslationId;
        mYoukrTranslationId = youkrTranslationId;
		mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslationId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param youkrTranslationId is the string resource ID for the word in the Ukrainian language
	 *
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     *
	 * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    Word(int defaultTranslationId, int youkrTranslationId, int imageResourceId, int audioResourceId) {
        mDefaultTranslationId = defaultTranslationId;
        mYoukrTranslationId = youkrTranslationId;
        mImageResourceId = imageResourceId;
		mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    int getDefaultTranslationId() {
        return mDefaultTranslationId;
    }

    /**
     * Get the Ukr translation of the word.
     */
    int getYoukrTranslationId() {
        return mYoukrTranslationId;
    }

    /**
     * Return the image resource ID of the word.
     */
    int getImageResourceId() {
        return mImageResourceId;
    }
	
	/**
     * Return the audio resource ID of the word.
     */
    int getAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslationId=" + mDefaultTranslationId +
                ", mYoukrTranslationId=" + mYoukrTranslationId +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}