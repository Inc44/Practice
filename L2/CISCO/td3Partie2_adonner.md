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
name Administratif
vlan 3
name Logistique
vlan 4
name Production
exit

interface range fa0/2-3
switchport mode access
switchport access vlan 2
no shutdown
exit

interface range fa0/4-5
switchport mode access
switchport access vlan 3
no shutdown
exit

interface range fa0/6-7
switchport mode access
switchport access vlan 4
no shutdown
exit

interface fa0/1
switchport mode trunk
no shutdown
end
write memory
```

## Multilayer Switch MS0

#### 1

```
enable
conf t
hostname MultilayerSwitch0
```

#### 3

###### a

```
vlan 2
name Administratif
vlan 3
name Logistique
vlan 4
name Production
vlan 8
name ServAutres
vlan 9
name Infra
exit

interface g0/2
switchport trunk encapsulation dot1q
switchport mode trunk
no shutdown
exit

interface range fa0/5-6
switchport mode access
switchport access vlan 2
no shutdown
exit

interface range fa0/3-4
switchport mode access
switchport access vlan 8
no shutdown
exit

interface range fa0/1-2
switchport mode access
switchport access vlan 9
no shutdown
exit
```

###### b

```
interface vlan 2
ip address 192.168.1.62 255.255.255.192
ip helper-address 192.168.111.1
no shutdown
exit

interface vlan 3
ip address 192.168.0.254 255.255.255.128
ip helper-address 192.168.111.1
no shutdown
exit

interface vlan 4
ip address 192.168.0.126 255.255.255.128
ip helper-address 192.168.111.1
no shutdown
exit

interface vlan 8
ip address 192.168.111.30 255.255.255.240
no shutdown
exit

interface vlan 9
ip address 192.168.111.14 255.255.255.240
no shutdown
exit
```

###### c

```
interface g0/1
no switchport
ip address 192.168.112.2 255.255.255.252
no shutdown
exit

ip route 0.0.0.0 0.0.0.0 192.168.112.1

end
write memory
```

## Router R0

#### 1

```
enable
conf t
hostname Router0
```

#### 4

```
interface g0/1
ip address 192.168.112.1 255.255.255.252
no shutdown
exit

interface g0/0
ip address 65.27.33.55 255.0.0.0
no shutdown
exit

ip route 192.168.0.0 255.255.0.0 192.168.112.2

ip route 0.0.0.0 0.0.0.0 g0/0

end
write memory
```

#### 5

```
enable
conf t
ip routing
exit
write memory
```

```
ping 65.100.47.5
```

#### 6

```
ping 65.100.47.5
```