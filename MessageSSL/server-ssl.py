import socket, ssl
import sys
import select

# HOST, PORT, CERT = 'example.com', 443, '/path/to/example.com.pem'
HOST, PORT, CERT = 'localhost', 500, './server.pem'

def handle(conn):
    print(conn.recv())
    conn.write(b'HTTP/1.1 200 OK\n\n%s' % conn.getpeername()[0].encode())
def main():
    sock = socket.socket()
    sock.bind((HOST, PORT))
    sock.listen(5)
    context = ssl.create_default_context(ssl.Purpose.CLIENT_AUTH)
    context.load_cert_chain(certfile=CERT)  # 1. key, 2. cert, 3. intermediates
    context.options |= ssl.OP_NO_TLSv1 | ssl.OP_NO_TLSv1_1  # optional
    context.set_ciphers('EECDH+AESGCM:EDH+AESGCM:AES256+EECDH:AES256+EDH')
    while True:
        conn = None
        ssock, addr = sock.accept()
        try:
            conn = context.wrap_socket(ssock, server_side=True)
            # handle(conn)
            try:
                text = conn.recv()
                if text:
                    print(b'%s' % (text))
                else:
                    text = sys.stdin.readline()
                    conn.write(b'%s' % (text))
            except:
                continue
        except ssl.SSLError as e:
            print(e)
        finally:
            if conn:
                conn.close()
if __name__ == '__main__':
    main()