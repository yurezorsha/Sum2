package yurez_orsha.sum2;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by HP on 17.11.2017.
 */

class MyAsyncTask extends AsyncTask<String, String, String> {
    String a, b, d, i, answerHTTP, text;

    MyAsyncTask(String a, String b, String d, String i) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.i = i;
    }

    String getAnswer() {
        return text;
    }

    String server = "http://192.168.43.146:8080/testapp/test";

    @Override
    protected void onPreExecute() {
        //a=String.valueOf(l1);
        //b=String.valueOf(l2);
        //d=editText.getText().toString();
        //a = editText.getText().toString();
        //b = editText2.getText().toString();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(server + "?a=" + a + "&b=" + b + "&d=" + d + "&i=" +i);

            urlConnection = (HttpURLConnection) url.openConnection();

            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                answerHTTP = convertInputStreamToString(urlConnection.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
            //textView.setText("pizdec");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return answerHTTP;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //editText2.setText(answerHTTP);

    }

    private String convertInputStreamToString(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}
