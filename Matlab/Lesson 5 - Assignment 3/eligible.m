function bool = eligible(v,q)
    results = [v q];
    flag = false;
    if mean(results) >= 92
        if (v > 88 && q > 88)
            flag = true;
        end   
    end 
    bool = flag;
end