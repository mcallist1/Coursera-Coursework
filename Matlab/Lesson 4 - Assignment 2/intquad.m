function my_matrix = intquad(n, m)
	my_zero = zeros(n,m);
	my_ones = ones(n,m);
	my_twos = 2*ones(n,m);
	my_threes = 3*ones(n,m);
	my_matrix = [my_zero,my_ones;my_twos,my_threes]