function bool = holiday(month,day)
    input = [month,day];
    
    jan_hol = [1,1];
    jul_hol = [7,4];
    dec_hol1 = [12,25];
    dec_hol2 = [12,31];
    
    if (isequal(input,jan_hol) || isequal(input,jul_hol) || isequal(input,dec_hol1) || isequal(input,dec_hol2))
        bool = true;
    else
        bool = false;
    end
     
end