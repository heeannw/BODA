package com.example.appt;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KccDataFetcher extends AsyncTask<Void, Void, String> {

    private static final String TAG = "KccDataFetcher";

    // local.properties의 KCC_API_KEY 값을 BuildConfig를 통해 주입합니다.
    private static final String API_KEY = BuildConfig.KCC_API_KEY;

    @Override
    protected String doInBackground(Void... voids) {
        try {
            String urlStr = "https://apis.data.go.kr/1570100/KccBmubislInfoService?"
                    + "serviceKey=" + API_KEY
                    + "&type=json" // JSON 형식 지정
                    + "&pageNo=1"
                    + "&numOfRows=10";

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            Log.d(TAG, "Response Code: " + responseCode);

            BufferedReader br;
            if (responseCode == 200) { // 성공
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else { // 에러
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();
            return sb.toString();

        } catch (Exception e) {
            Log.e(TAG, "API 호출 실패", e);
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            Log.d(TAG, "API 응답: " + result);
            // 여기서 JSON 파싱해서 화면에 표시하거나 필요한 작업 수행
        } else {
            Log.e(TAG, "API 응답이 null입니다.");
        }
    }
}
