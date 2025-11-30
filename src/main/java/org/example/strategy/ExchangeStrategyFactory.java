package org.example.strategy;

import org.example.model.Currency;

import java.util.HashMap;
import java.util.Map;

public class ExchangeStrategyFactory {
    private static final Map<String, ExchangeStrategy> strategies = new HashMap<>();

    static {
        strategies.put("HUF-HUF", new NoExchange());
        strategies.put("USD-USD", new NoExchange());
        strategies.put("EUR-EUR", new NoExchange());


        strategies.put("HUF-USD", new HufUsdExchange(true));
        strategies.put("USD-HUF", new HufUsdExchange(false));
        strategies.put("HUF-EUR", new HufEurExchange(true));
        strategies.put("EUR-HUF", new HufEurExchange(false));
        strategies.put("USD-EUR", new EurUsdExchange(true));
        strategies.put("EUR-USD", new EurUsdExchange(false));
    }

    public static ExchangeStrategy getExchangeStrategy(Currency from, Currency to) {
        String key = from.name() + "-" + to.name();
        ExchangeStrategy strategy = strategies.get(key);
        if (strategy == null) {
            throw new IllegalArgumentException();
        }
        return strategy;
    }
}
