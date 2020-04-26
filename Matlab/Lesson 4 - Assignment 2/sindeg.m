function [sine, av] = sindeg(deg)
	sine_converter = 0.01745240643;
	av = numel(deg(:));
	sine = deg.*sine_converter;
end