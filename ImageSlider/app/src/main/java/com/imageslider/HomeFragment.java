package com.imageslider;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;


import org.json.JSONArray;
import org.json.JSONObject;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Insonix on 7/29/2016.
 */
public class HomeFragment extends Fragment implements ViewPagerEx.OnPageChangeListener, BaseSliderView.OnSliderClickListener, View.OnClickListener {

    private View mView;
    private SliderLayout mDemoSlider;
    Fragment fragment;
    private String url;
    HashMap<String, String> url_slider;

    Bundle bundle1;

    ArrayList<HashMap<String, String>> home_category_list;
    HashMap<String, String> category_id;
    FragmentTransaction fragmentTransaction;
    private ArrayList<Group> ExpListItems;
    FragmentManager fragmentManager;
   // private ExpandListAdapter ExpAdapter;
    private ExpandableListView ExpandList;
    private ProgressDialog progressDialog;

    private ImageView pageImage1, pageImage2, pageImage3, pageImage4, pageImage5, pageImage6, pageImage7, pageImage8, pageImage9;
   // ImageLoader imageLoader;
   // DisplayImageOptions options;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.home_fargment, container, false);

        initUI();

        clik_listener();

       /* mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);


        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("slideimage1",R.drawable.image1);
        file_maps.put("slideimage2",R.drawable.image2);
        file_maps.put("slideimage3",R.drawable.image3);
        file_maps.put("slideimage4", R.drawable.image4);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        ListView l = (ListView)findViewById(R.id.transformers);
        l.setAdapter(new TransformerAdapter(this));
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
                Toast.makeText(MainActivity1.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });*/

        return mView;
    }

    private void initUI() {
        url_slider = new HashMap<String, String>();
        home_category_list = new ArrayList<>();
        category_id = new HashMap<String, String>();
        progressDialog = new ProgressDialog(getActivity());
        mDemoSlider = (SliderLayout) mView.findViewById(R.id.slider);

        pageImage1 = (ImageView) mView.findViewById(R.id.category1);
        pageImage2 = (ImageView) mView.findViewById(R.id.category2);
        pageImage3 = (ImageView) mView.findViewById(R.id.category3);
        pageImage4 = (ImageView) mView.findViewById(R.id.category4);
        pageImage5 = (ImageView) mView.findViewById(R.id.category5);
        pageImage6 = (ImageView) mView.findViewById(R.id.category6);
        pageImage7 = (ImageView) mView.findViewById(R.id.category7);
        pageImage8 = (ImageView) mView.findViewById(R.id.category8);
        pageImage9 = (ImageView) mView.findViewById(R.id.category9);
     /*   ExpandList = (ExpandableListView)mView.findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
*/
    }


    void clik_listener() {
        pageImage1.setOnClickListener(this);
        pageImage2.setOnClickListener(this);
        pageImage3.setOnClickListener(this);
        pageImage4.setOnClickListener(this);
        pageImage5.setOnClickListener(this);
        pageImage6.setOnClickListener(this);
        pageImage7.setOnClickListener(this);
        pageImage8.setOnClickListener(this);
        pageImage9.setOnClickListener(this);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //    Toast.makeText(getActivity(),slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    private ProgressDialog pDialog;


   /* private void getData() {
        RestApi restApi = new RestApi();
        Service service = restApi.createService("http://52.35.22.61/shopping/web/listimageNew.php");
        Call<MyBean> call = service.signin_Service();
        call.enqueue(new Callback<MyBean>() {
            @Override
            public void onResponse(Call<MyBean> call, Response<MyBean> response) {
                Log.e("response", ":: " + response.raw());
                if (response.body().getStatus().equals("ok")) {

                    for (int i = 0; i <response.body().getResponse().getSliderImage().size(); i++) {
                       com.imageslider.Response myBeans = new com.imageslider.Response();
                        myBeans.setSliderImage(response.body().getResponse().getSliderImage().get(i).ge);
                        myBeans.setDetails(workoutSearchBean.getReturnset()[i].getWeights());
                        arr.add(myBeans);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MyBean> call, Throwable t) {
                Log.e("response", ":: " + t.getMessage());
            }
        });
    }*/
    /*private void callRequest() {

        url = "http://52.35.22.61/shopping/web/listimageNew.php";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d("res:", "resss" + jsonObject.toString());
                try {
                    String Status = jsonObject.getString("status");
                    if (Status.equalsIgnoreCase("ok")) {

                        JSONObject response = jsonObject.getJSONObject("response");
                        JSONArray jsonArray = response.getJSONArray("slider_image");
                        JSONArray jsonArray1 = response.getJSONArray("page_image");
                        JSONArray jsonArray2 = response.getJSONArray("banner_image");
//                        for (int i = 0; i < jsonArray.length(); i++) {
                        url_slider.put("slider_1", jsonArray.getString(0));
                        url_slider.put("slider_2", jsonArray.getString(1));
                        url_slider.put("slider_3", jsonArray.getString(2));
                        url_slider.put("slider_4", jsonArray.getString(3));
                        for (String name : url_slider.keySet()) {
                            TextSliderView textSliderView = new TextSliderView(getActivity());
                            // initialize a SliderLayout
                            textSliderView
                                    .image(url_slider.get(name))
                                    .setScaleType(BaseSliderView.ScaleType.Fit);

                            //add your extra information
                            textSliderView.bundle(new Bundle());
                            textSliderView.getBundle()
                                    .putString("extra", name);

                            mDemoSlider.addSlider(textSliderView);

                            imageLoader.displayImage(jsonArray1.getJSONObject(0).getString("image_url"), pageImage1, options);
                            imageLoader.displayImage(jsonArray1.getJSONObject(1).getString("image_url"), pageImage2, options);
                            imageLoader.displayImage(jsonArray1.getJSONObject(2).getString("image_url"), pageImage3, options);
                            imageLoader.displayImage(jsonArray1.getJSONObject(3).getString("image_url"), pageImage4, options);
                            imageLoader.displayImage(jsonArray1.getJSONObject(4).getString("image_url"), pageImage5, options);
                            imageLoader.displayImage(jsonArray1.getJSONObject(5).getString("image_url"), pageImage6, options);
                            imageLoader.displayImage(jsonArray1.getJSONObject(6).getString("image_url"), pageImage7, options);
                            imageLoader.displayImage(jsonArray1.getJSONObject(7).getString("image_url"), pageImage8, options);
                            imageLoader.displayImage(jsonArray2.getString(0), pageImage9, options);
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                category_id = new HashMap<>();
                                JSONObject id = jsonArray1.getJSONObject(i);
//                                JSONArray depart_id=response.getJSONArray("depart_id");
//                                JSONArray cat_id=response.getJSONArray("cat_id");
//                                JSONArray sub_cat_id=response.getJSONArray("sub_cat_id");
                                category_id.put("department_id", id.getString("depart_id"));
                                category_id.put("category_id", id.getString("cat_id"));
                                category_id.put("sub_cat_id", id.getString("sub_cat_id"));
                                home_category_list.add(category_id);
                            }
                            Log.d("list", home_category_list.toString());

                        }


                    }

//                        Toast.makeText(Login.this, "Login successfully", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Log.d("eeeee:", "eeeee" + e);
                }
                ((MainActivity) getActivity()).dismissProgressDialog();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                // Log.d("volleyError:", "volleyError" + volleyError);
                Toast.makeText(getActivity(), "slow internet connection", Toast.LENGTH_SHORT).show();
            }


        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, "tag_json");
//        JsonObjectRequest JsonObjectRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(getActivity(),"success",Toast.LENGTH_SHORT).show();
//                String status=respons
////                Type type = new TypeToken<MyBean>() {
////                }.getType();
////                mBean = Utilities1.getInstance().getGson().fromJson(response.toString(), type);
////                Type type1 = new TypeToken<ArrayList<MyBean>>() {
////                }.getType();
////                mArrBean = Utilities1.getInstance().getGson().fromJson(response.toString(), type1);
////
////
////                url_slider.put("Hannibal", mBean.getResponse().getSliderImage().get(0));
////                url_slider.put("Big Bang Theory", mBean.getResponse().getSliderImage().get(1));
////                url_slider.put("House of Cards", mBean.getResponse().getSliderImage().get(2));
////                url_slider.put("Game of Thrones", mBean.getResponse().getSliderImage().get(3));
//////                imageLoader.displayImage(mBean.getResponse().getPageImage(), pageImage1, options);
//
//                progressDialog.dismiss();
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            Toast.makeText(getActivity(),"slow internet connection",Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        AppController.getInstance().addToRequestQueue(stringRequest, "tag_json");
    }*/


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onClick(View view) {

    }

  /*  @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.category1:
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();
                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(0).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(0).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(0).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();


                break;
            case R.id.category2:
                Log.d("hii", "22");
                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(1).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(1).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(1).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();


                // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();
                Log.d("hii222", "22");
                break;
            case R.id.category3:
                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(2).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(2).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(2).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();


                // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();

                break;
            case R.id.category4:

                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(3).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(3).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(3).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();


                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();

                break;
            case R.id.category5:

                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(4).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(4).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(4).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();

                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();

                break;
            case R.id.category6:

                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(5).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(5).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(5).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();

                //   getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();

                break;
            case R.id.category7:

                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(6).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(6).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(6).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();

                //  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();

                break;
            case R.id.category8:
                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(7).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(7).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(7).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();


                // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();

                break;
            case R.id.category9:

                fragment = new ProductCategoryList();
                bundle1 = new Bundle();
                bundle1.putString("cat_id", home_category_list.get(8).get("category_id"));
                bundle1.putString("subcat_id", home_category_list.get(8).get("sub_cat_id"));
                bundle1.putString("depart_id", home_category_list.get(8).get("department_id"));
                fragment.setArguments(bundle1);
                fragmentManager = ((MainActivity) getActivity()).getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment, "tag").addToBackStack("product_category").commit();

//               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductCategoryList()).addToBackStack("product_category").commit();

                break;


        }


    }*/
}
