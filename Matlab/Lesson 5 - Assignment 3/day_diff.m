function number_of_days = day_diff(month1, day1, month2,day2)
    
    days_in_month = [31 28 31 30 31 30 31 31 30 31 30 31];
    
    months_31 = [1,3,5,7,8,10,12]; 
    months_30 = [4,6,9,11];
    month_28 = [2];
    
    if (~isscalar(month1) || ~isscalar(month2) || ~isscalar(day1) || ~isscalar(day2) || ...
        month1 > 12 || month2 > 12 || month1 < 1 || month2 < 1 || ... 
        month1~=fix(month1)|| day1~=fix(day1) || month2~=fix(month2) || day2 ~=fix(day2)  )
            number_of_days = -1;
            return;
    else
        if( (ismember(month1,months_31) && (day1 >31 || day1<0) ) || (ismember(month2,months_31) && (day2 >31 || day2<0)) ...
            || (ismember(month1,months_30) && (day1 >30 || day1<0) ) || (ismember(month2,months_30) && (day2 >30 || day2<0)) ...
            || (ismember(month1,month_28) && (day1 >28 || day1<0) ) || (ismember(month2,month_28) && (day2 >28 || day2<0)) )
                number_of_days = -1;
                return;
        end
    end
    
    date_one_number = sum(days_in_month(1:month1-1)) + day1;
    date_two_number = sum(days_in_month(1:month2-1)) + day2;
    
    number_of_days = abs(date_one_number-date_two_number);
    
end