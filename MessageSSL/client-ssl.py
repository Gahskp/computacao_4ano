import socket, ssl
import sys
import select

HOST, PORT = 'localhost', 443

def handle(conn):
    conn.write(b'GET / HTTP/1.1\n\r')
    print(conn.recv().decode())

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    conn = ssl.wrap_socket(sock, cert_reqs=ssl.CERT_REQUIRED, ca_certs='./cert.pem')

    try:
        conn.connect((HOST, PORT))
        # handle(conn)
        while True:
            while sys.stdin in select.select([sys.stdin], [], [], 0)[0]:
                line = sys.stdin.readline()
                if line:
                    print 'Ok'
                    conn.write(b'%s' % (line))
                else:
                    print 'eof'

            # if stdin
            # text = sys.stdin.readline()
            # conn.write(b'%s' % (text))
    finally:
        conn.close()

if __name__ == '__main__':
    main()
