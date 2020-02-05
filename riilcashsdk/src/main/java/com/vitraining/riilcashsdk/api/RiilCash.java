package com.vitraining.riilcashsdk.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.vitraining.riilcashsdk.util.Commons;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiilCash {
    private static final String TAG = RiilCash.class.getSimpleName();
    private String ret;
    private ProgressDialog progressDialog;
    private String url;
    private Context context;

    public RiilCash(Context context, String url) {
        progressDialog = new ProgressDialog(context);
        this.url = url;
        this.context = context;
    }

    public void login(String name, String password, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");
        Map<String, Object> m = new HashMap<>();
        m.put("name", name);
        m.put("password", password);

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call<JsonElement> call = apiService.login("application/x-www-form-urlencoded", m);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void peoples(
            String name,
            String domain,
            String email,
            String mobile,
            String id_type,
            String id_number,
            String dob,
            String country,
            Integer country_id,
            String password,
            Integer pin,
            String role,
            final RiilCashCallback riilCashCallback) {
        Map<String, Object> m = new HashMap<>();
        m.put("name", name);
        m.put("domain", domain);
        m.put("email", email);
        m.put("mobile", mobile);
        m.put("id_type", id_type);
        m.put("id_number", id_number);
        m.put("dob", dob);
        m.put("country", country);
        m.put("country_id", country_id);
        m.put("password", password);
        m.put("pin", pin);
        m.put("role", role);

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call<JsonElement> call = apiService.peoples("application/x-www-form-urlencoded", m);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void country(String token, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.country(token);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void currency(String token, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.currency(token);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void mto(String token, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.mto(token);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void bank(String token, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.bank(token);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void provider(String token, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.provider(token);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void listUser(String token, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.listUser(token);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void getUser(String token, String rillcash_id, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.getUser(token, rillcash_id);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void checkAccount(String token, String account_id, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        Map<String, Object> m = new HashMap<>();
        m.put("account_id", account_id);

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call<JsonElement> call = apiService.checkAccount(token, m);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void peopleByName(String token, String name, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.peopleByName(token, name);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void peopleByParent(String token, Integer id, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.peopleByParent(token, id);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void forgotPassword(String token, String name, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.forgotPassword(token, name);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void singlePeopleByName(String token, String name, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.singlePeopleByName(token, name);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void deposits(String token,
                           String account_id,
                           Double amount,
                           String currency,
                           Integer method,
                           String unique_id,
                           String from_name,
                           final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        Map<String, Object> m = new HashMap<>();
        m.put("account_id", account_id);
        m.put("amount", amount);
        m.put("currency", currency);
        m.put("method", method);
        m.put("unique_id", unique_id);
        m.put("from_name", from_name);

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call<JsonElement> call = apiService.deposits(token, m);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void getDeposit(String token, String name, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.getDeposit(token, name);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void processDeposit(String token, String unique_id, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.processDeposit(token, unique_id);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void withdrawals(String token,
                           String account_id,
                           Double amount,
                           String currency,
                           Integer method,
                           String unique_id,
                           String from_name,
                           final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        Map<String, Object> m = new HashMap<>();
        m.put("account_id", account_id);
        m.put("amount", amount);
        m.put("currency", currency);
        m.put("method", method);
        m.put("unique_id", unique_id);
        m.put("from_name", from_name);

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call<JsonElement> call = apiService.withdrawals(token, m);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void getWithdrawal(String token, String name, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.getWithdrawal(token, name);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void processWithdrawal(String token, String unique_id, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.processWithdrawal(token, unique_id);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void getBankTransfer(String token, String unique_id, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.getBankTransfer(token, unique_id);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void processBankTransfer(String token, String unique_id, final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call <JsonElement> call = apiService.processBankTransfer(token, unique_id);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void createPayment(String token,
                              String source_account_pub,
                              String dest_account_pub,
                              Double amount,
                              String currency,
                              String unique_code,
                              final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        Map<String, Object> m = new HashMap<>();
        m.put("source_account_pub", source_account_pub);
        m.put("dest_account_pub", dest_account_pub);
        m.put("amount", amount);
        m.put("currency", currency);
        m.put("unique_code", unique_code);

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call<JsonElement> call = apiService.createPayment(token, m);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }

    public void sendMoney(String token,
                                String source_account_pub,
                                String dest_account_id,
                                Double amount,
                                Double amount_receive,
                                String currency,
                                String currency_destination,
                                String unique_code,
                                Integer method,
                                Integer method_source,
                                String date_order,
                                final RiilCashCallback riilCashCallback) {
        Commons.showProgressDialog(progressDialog, "Loading...");

        Map<String, Object> m = new HashMap<>();
        m.put("source_account_pub", source_account_pub);
        m.put("dest_account_id", dest_account_id);
        m.put("amount", amount);
        m.put("amount_receive", amount_receive);
        m.put("currency", currency);
        m.put("currency_destination", currency_destination);
        m.put("method", method);
        m.put("method_source", method_source);
        m.put("unique_code", unique_code);
        m.put("date_order", date_order);

        ApiService apiService = ApiClient.getClient(context, url).create(ApiService.class);
        Call<JsonElement> call = apiService.sendMoney(token, m);
        call.enqueue(new Callback<JsonElement>() {
            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    int status = jsonObject.getInt("status");

                    if (status == 0) {
                        riilCashCallback.onSuccess(jsonObject.toString(4));
                    } else {
                        riilCashCallback.onError(jsonObject.toString(4));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    riilCashCallback.onError(e.toString());
                }

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                Log.e("Error", t.toString());
                riilCashCallback.onError(t.toString());
                progressDialog.dismiss();
            }
        });
    }
}
