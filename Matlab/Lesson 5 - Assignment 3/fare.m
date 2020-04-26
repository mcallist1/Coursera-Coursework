function dollars = fare(dist, age)
    miles = round(dist);
    
    if miles <= 1
        fare = 2; 
    elseif (miles > 1 && miles <= 10)
        fare = 2 + (0.25 * (miles-1));
    elseif (miles > 10)
        fare = 2 + (0.25 * 9) + ((miles-10)*0.1);
    end
    
    if (age <= 18 || age >= 60)
        fare = fare * 0.8;
    end 
    
    dollars = fare;
end    