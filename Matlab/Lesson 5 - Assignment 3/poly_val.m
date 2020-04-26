function p = poly_val(c0,c,x)
    
    if(isempty(c))
        p = c0;
    elseif(isscalar(c))
        p = c0+c*x;
    else
        if iscolumn(c)
            c = c.';
        end    
      powers = [1:1:length(c)];
      x_vect = ones(1,length(c) ) * x;
      x_power = x_vect .^ powers;
      
      mult = (c .* x_power);
      p = c0 + sum(mult(:));
    end
     
end