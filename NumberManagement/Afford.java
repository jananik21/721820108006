import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class NumberManagement {

    public static void main(String[] args) {
        String apiUrl1 = "http://20.244.56.144/numbers/primes";
        String apiUrl2 = "http://20.244.56.144/numbers/fibo";
        String apiUrl3 = "http://20.244.56.144/numbers/odd";
        String apiUrl4 = "http://20.244.56.144/numbers/rand";

        try {
            URL url = new URL(apiUrl1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                System.out.println("Numbers: " + response.toString());
            } else {
                System.out.println("Failed to fetch prime numbers. HTTP error code: " + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL(apiUrl2);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the API response and convert it to the Fibonacci series
                String[] numbers = response.toString().trim().split("\\s+");
                int n = numbers.length;

                int[] fibonacciSeries = new int[n];
                for (int i = 0; i < n; i++) {
                    fibonacciSeries[i] = Integer.parseInt(numbers[i]);
                }

                // Print the Fibonacci series in the specified format
                for (int num : fibonacciSeries) {
                    System.out.print(num + " ");
                }
            } else {
                System.out.println("Failed to fetch Fibonacci numbers. HTTP error code: " + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL(apiUrl3);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                System.out.println("Numbers: " + response.toString());
            } else {
                System.out.println("Failed to fetch odd numbers. HTTP error code: " + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            URL url = new URL(apiUrl4);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                System.out.println("Numbers: " + response.toString());
            } else {
                System.out.println("Failed to fetch random numbers. HTTP error code: " + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
