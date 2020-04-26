function orms = odd_rms(nn)
    original = (1:1:nn*2);
    evens = original(rem(original,2)==0);
    odds = evens - 1;
    odd_sq = odds.^2;
    orms= sqrt(mean(odd_sq));
end