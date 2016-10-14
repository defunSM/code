import math

def main():

    circumference_of_earth_in_km = 40000
    time_for_one_rotation_in_hours = 24
    minutes_in_hour = 60
    seconds_in_minute = 60

    radius_of_earth = circumference_of_earth_in_km / (2 * math.pi)

    print("Radius of Earth: %d km" % radius_of_earth)

    velocity_of_earths_rotation = (circumference_of_earth_in_km * 1000) / (time_for_one_rotation_in_hours * minutes_in_hour * seconds_in_minute)

    print("Velocity: %d m/s") % velocity_of_earths_rotation

    acceleration_of_earth = (velocity_of_earths_rotation ** 2) / (radius_of_earth * 1000)

    print("Acceleration: %f m/s^2") % acceleration_of_earth

main()
