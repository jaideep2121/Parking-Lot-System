package Factory;

import Enums.PrincingStratargy;
import Strategy.Pricing.EventBasedPricing;
import Strategy.Pricing.PricingStrategy;
import Strategy.Pricing.TimeBasedPricing;

public class PricingStratgy {

    public static PricingStrategy get(PrincingStratargy type){
       return  switch(type){
            case EVENT_BASED -> new EventBasedPricing();
            case TIME_BASED -> new TimeBasedPricing();
        };
    }

}
