function [time_mins,dist_in_miles] = light_speed(dist_in_km)
    km_per_min_light = 300000*60
    time_mins = dist_in_km./km_per_min_light
    dist_in_miles = dist_in_km/1.609