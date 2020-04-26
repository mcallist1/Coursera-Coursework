function peri = peri_sum(A)
    A(2:end-1,2:end-1) = 0
    peri = sum(A(:))