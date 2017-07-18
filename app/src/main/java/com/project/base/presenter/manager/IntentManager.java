package com.project.base.presenter.manager;

import org.androidannotations.annotations.EBean;

/**
 * Created by faizf on 2/11/2017.
 */
@EBean
public final class IntentManager {

    public interface Code {
        int FORM = 6001;
        int REQUEST_CAMERA = 1;
        int REQUEST_CAMERA_FARMER = 2;
        int BACKGROUND = 1;
        int BITMAP = 2;

    }

/*    public static String setDataResult(Intent data, ImageView image, int setImage, Resources resources, Context context) {
        String path = data.getStringExtra(UtilsCamera.resultTagCamera);
        String urlImage = sendImage(path, context);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        if (path != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(path, options);
            if (bitmap != null) {
                image.setImageBitmap(null);
                switch (setImage) {
                    case Code.BACKGROUND:
                        Drawable drawable = new BitmapDrawable(resources, bitmap);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            //image.setBackground(drawable);
                            image.setImageDrawable(drawable);

                        } else
                            image.setImageDrawable(drawable);
                            //image.setBackgroundDrawable(drawable);
                        break;
                    case Code.BITMAP:
                        image.setImageBitmap(bitmap);
                        break;
                }
            }
        }
        return urlImage;
    }

    private static String sendImage(final String path, final Context context) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(context.getResources().getString(R.string.content_progress));
        progressDialog.show();
        final String[] urlImage = {""};
        File file = new File(path);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("image", file.getName(),
                requestBody);
        ApiConfig apiConfig = ApiClient.getClient((Activity) context).create(ApiConfig.class);
        Call<ResponseUploadPicture> uploadImage = apiConfig.getUploadImage(multipartBody);
        uploadImage.enqueue(new Callback<ResponseUploadPicture>() {
            @Override
            public void onResponse(Call<ResponseUploadPicture> call, Response<ResponseUploadPicture> response) {
                if (response.body().getStatus() == 401) {
                    Token token = new Token(context);
                    token.setAuthToken(response.body().getNewAuthToken());
                    sendImage(path, context, req);
                } else if (response.body().getStatus() == 202) {
                    urlImage[0] = response.body().getData().getImageUrl();
                    req.setFarmerImage(response.body().getData().getImageUrl());
                    progressDialog.dismiss();
                } else {
                    Util util = new Util();
                    util.showDialogError(context, response.body().getMessage());
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseUploadPicture> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                //Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return urlImage[0];
    }

    public static void toNavigationHome(Activity activity) {
        NavigationActivity_.intent(activity).start();
        activity.finish();
    }
  */
}
