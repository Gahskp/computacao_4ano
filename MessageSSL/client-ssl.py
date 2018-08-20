import socket, ssl

HOST, PORT = 'localhost', 4443

def handle(conn):
    conn.write(b'GET / HTTP/1.1\n\r')
    conn.write(b'Host: www.google.com\n\r\n\r')
    print(conn.recv().decode())

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    conn = ssl.wrap_socket(sock, cert_reqs=ssl.CERT_REQUIRED, ca_certs='./cert.pem')

    try:
        conn.connect((HOST, PORT))
        handle(conn)
        while True:
            text = raw_input()
            print '%s' % (text)
    finally:
        conn.close()

if __name__ == '__main__':
    main()
