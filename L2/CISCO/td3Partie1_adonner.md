## Router0

#### 1

```
enable
conf t
hostname Router0
```

#### 4

```
interface g0/0
ip address 192.168.10.106 255.255.255.252
no shutdown
exit

interface g0/1
ip address 92.169.148.18 255.0.0.0
no shutdown
exit

ip route 192.168.10.0 255.255.255.192 192.168.10.105
ip route 192.168.10.64 255.255.255.224 192.168.10.105
ip route 192.168.10.96 255.255.255.248 192.168.10.105
ip route 0.0.0.0 0.0.0.0 92.200.10.1

end
write memory
```

## Router1

#### 1

```
enable
conf t
hostname Router1
```

#### 3

###### a

```
interface g0/1.2
encapsulation dot1q 2
ip address 192.168.10.62 255.255.255.192
ip helper-address 192.168.10.97
no shutdown
exit

interface g0/1.3
encapsulation dot1q 3
ip address 192.168.10.94 255.255.255.224
ip helper-address 192.168.10.97
no shutdown
exit

interface g0/1.9
encapsulation dot1q 9
ip address 192.168.10.102 255.255.255.248
no shutdown
exit
```

#### 3

###### b

```
interface g0/0
ip address 192.168.10.105 255.255.255.252
no shutdown
exit
```

#### 4

```
ip route 0.0.0.0 0.0.0.0 192.168.10.106

end
write memory
```

## Switch0

#### 1

```
enable
conf t
hostname Switch0
```

#### 2

```
vlan 2
name Developpement
vlan 3
name Administratif
vlan 9
name Serveurs
exit

interface range fa0/2-3
switchport mode access
switchport access vlan 9
no shutdown
exit

interface range fa0/4-5
switchport mode access
switchport access vlan 2
no shutdown
exit

interface range fa0/6-7
switchport mode access
switchport access vlan 3
no shutdown
exit

interface fa0/1
switchport mode trunk
no shutdown
end
write memory
```

#### 5

```
enable
conf t
interface g0/1
no ip address
shutdown
no shutdown
exit
end
write memory
```

```
ping 92.169.148.18
```

#### 6

```
ping 92.169.148.18
```