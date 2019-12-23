import socket

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)


def scan_port(ip, port):
    try:
        sock.connect((ip.port))
        return True
    except:
        return False


def enumerate_ports(minn, maxx, ip):
    min_num = int(minn)
    max_num = int(maxx)
    print("Now Scanning for ports...")
    for portnum in range(min_num, max_num):
        result = scan_port(ip, portnum)
        if result:
            print("You can connect to port # ", portnum)
        else:
            print("You can not connect to port # ", portnum)


def main():
    min_input = input("Please enter minimum port # ")
    max_input = input("Please enter maximum port # ")
    ip_input = input("PLease enter IP address ")
    enumerate_ports(min_input, max_input, ip_input)


main()
