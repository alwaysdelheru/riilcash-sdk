# Riilcash SDK for Java Android
Java Android library for connect riilcash network

## Installation
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

```
allprojects {
    repositories {
    ...
    maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```
dependencies {
    implementation 'com.github.alwaysdelheru:riilcash-sdk:1.0.1'
}
```

## Usage Example
Here are some examples of using this library:

#### Login
```
private void login() {
    RiilCash riilCash = new RiilCash(this);
    riilCash.login(this, "ca", "1", new RiilCashCallback() {
        public void onSuccess(String response){
            txtResult.setText(response);
            Log.e(TAG, "login--> onSuccess: " + response);
        }

        public void onError(String response){
            txtResult.setText(response);
            Log.e(TAG, "login--> onError: " + response);
        }
    });
}
```

#### Sign Up
```
private void createAccount() {
    RiilCash riilCash = new RiilCash(this);
    result = riilCash.peoples(
            this,
            "heru",
            "remcash.com",
            "heru@gmail.com",
            "087812341234",
            "National ID",
            "1234567890",
            "1997-06-06",
            "Indonesia",
            1,
            "123456",
            1234,
            "user");
    txtResult.setText(result);
    Log.e(TAG, "createAccount--> result: " + result);
}
```

#### Get Country List
```
private void country() {
    RiilCash riilCash = new RiilCash(this);
    riilCash.country(this, "lll", new RiilCashCallback() {
        public void onSuccess(String response){
            txtResult.setText(response);
            Log.e(TAG, "country--> onSuccess: " + response);
        }

        public void onError(String response){
            txtResult.setText(response);
            Log.e(TAG, "country--> onError: " + response);
        }
    });
}
```

## Release History

* 1.0.1
    * Work in progress (initial commit)
