function [estimate, k] = approximate_e(delta)
    
    count = 1;
    est = 1;
    denom = 1;
    
    while abs(est-exp(1)) > delta 
        est = est + (1/denom);
        count = count + 1;
        denom = count * denom;
    end
    
     estimate = est;
     k = count - 1;
end




