package com.imageslider;

/**
 * Created by PC20 on 8/29/2015.
 */
public class MessageListBean {
    public String getClientImage() {
        return clientImage;
    }

    public void setClientImage(String clientImage) {
        this.clientImage = clientImage;
    }

    public String getTrainerImage() {
        return trainerImage;
    }

    public void setTrainerImage(String trainerImage) {
        this.trainerImage = trainerImage;
    }

    public String getClientMessage() {
        return clientMessage;
    }

    public void setClientMessage(String clientMessage) {
        this.clientMessage = clientMessage;
    }

    public String getTrainerMessage() {
        return trainerMessage;
    }

    public void setTrainerMessage(String trainerMessage) {
        this.trainerMessage = trainerMessage;
    }

    public String getMessageFor() {
        return messageFor;
    }

    public void setMessageFor(String messageFor) {
        this.messageFor = messageFor;
    }

    public boolean isImageMessage() {
        return isImageMessage;
    }

    public void setIsImageMessage(boolean isImageMessage) {
        this.isImageMessage = isImageMessage;
    }

    public boolean isUploadGallery() {
        return uploadGallery;
    }

    public void setUploadGallery(boolean uploadGallery) {
        this.uploadGallery = uploadGallery;
    }


    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }


    boolean uploadGallery;
    boolean isImageMessage;
    String messageFor;
    String trainerImage;
    String clientImage;
    String clientMessage;
    String trainerMessage;

    String messageId;
}
