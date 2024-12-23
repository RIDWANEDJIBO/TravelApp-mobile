package fr.mycompany.travelapp.data.service;

public interface OnImageFetchedCallback {
    void onSuccess(String imageUrl);
    void onFailure(String errorMessage);
}
