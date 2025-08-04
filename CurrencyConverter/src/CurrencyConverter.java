import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get base currency from user
        System.out.print("Enter base currency (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        // Get target currency from user
        System.out.print("Enter target currency (e.g., USD, EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Get amount to convert
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Fetch exchange rates and convert
        try {
            double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
            System.out.printf("%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    private static double convertCurrency(String baseCurrency, String targetCurrency, double amount) throws Exception {
        // Fetch exchange rates
        String urlString = API_URL + baseCurrency;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new Exception("Failed to fetch data from API");
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parse JSON response
        String jsonResponse = response.toString();
        Map<String, Double> rates = parseRates(jsonResponse);

        // Convert amount
        if (!rates.containsKey(targetCurrency)) {
            throw new Exception("Target currency not found");
        }

        double exchangeRate = rates.get(targetCurrency);
        return amount * exchangeRate;
    }

    private static Map<String, Double> parseRates(String jsonResponse) {
        Map<String, Double> rates = new HashMap<>();
        String[] parts = jsonResponse.split("\"rates\":\\{")[1].split("\\}")[0].split(",");

        for (String part : parts) {
            String[] rate = part.split(":");
            String currency = rate[0].replace("\"", "").trim();
            double value = Double.parseDouble(rate[1].trim());
            rates.put(currency, value);
        }

        return rates;
    }
}
