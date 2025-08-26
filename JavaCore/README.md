# Java Core - Tổng quan về Java 17

## 📋 Mục lục
1. [Quản lý bộ nhớ trong Java](#quản-lý-bộ-nhớ-trong-java)
2. [Tính rõ ràng và an toàn](#tính-rõ-ràng-và-an-toàn)
3. [Tính năng Java 17](#tính-năng-java-17)
4. [So sánh với các ngôn ngữ khác](#so-sánh-với-các-ngôn-ngữ-khác)

---

## 🧠 Quản lý bộ nhớ trong Java

### **1. Garbage Collection (GC)**
Java sử dụng **Automatic Memory Management** thông qua Garbage Collector:

```java
// Ví dụ về GC
public class MemoryExample {
    public void createObjects() {
        // Object được tạo trong heap
        String str1 = new String("Hello");
        String str2 = new String("World");
        
        // Khi method kết thúc, str1 và str2 có thể bị GC thu hồi
        // nếu không có reference nào trỏ đến chúng
    }
}
```

### **2. Memory Areas**

#### **Heap Memory**
- **Young Generation**: Eden, Survivor spaces (S0, S1)
- **Old Generation**: Tenured space
- **Metaspace**: Class metadata (thay thế PermGen từ Java 8)

#### **Stack Memory**
- Lưu trữ local variables, method calls
- Mỗi thread có stack riêng

#### **Native Memory**
- Direct ByteBuffers
- JNI calls
- Native libraries

### **3. GC Algorithms**
```java
// Các loại GC trong Java 17
-XX:+UseG1GC          // G1 Garbage Collector (mặc định)
-XX:+UseZGC           // Z Garbage Collector (low-latency)
-XX:+UseShenandoahGC  // Shenandoah GC
-XX:+UseParallelGC    // Parallel GC
-XX:+UseSerialGC      // Serial GC
```

---

## 🛡️ Tính rõ ràng và an toàn

### **1. Strong Typing**
```java
// Java yêu cầu khai báo kiểu dữ liệu rõ ràng
int number = 42;           // ✅ Đúng
String text = "Hello";     // ✅ Đúng
// number = "text";        // ❌ Compile error
```

### **2. Explicit Memory Management**
```java
// Java không cho phép truy cập trực tiếp vào bộ nhớ
// Không có pointers như C/C++
public class SafeExample {
    private int[] array = new int[10];
    
    // Không thể truy cập địa chỉ bộ nhớ trực tiếp
    // Không có: int* ptr = &array[0];
}
```

### **3. Exception Handling**
```java
public class ExceptionExample {
    public void safeDivision(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        } finally {
            System.out.println("Cleanup code here");
        }
    }
}
```

### **4. Access Modifiers**
```java
public class AccessExample {
    public String publicField;      // Truy cập từ mọi nơi
    protected String protectedField; // Truy cập trong package và subclass
    String defaultField;            // Truy cập trong package
    private String privateField;    // Chỉ truy cập trong class
}
```

---

## 🚀 Tính năng Java 17

### **1. Pattern Matching for switch (Preview)**
```java
// Java 17 - Pattern matching trong switch
public String getShapeInfo(Object obj) {
    return switch (obj) {
        case String s -> "String: " + s;
        case Integer i -> "Integer: " + i;
        case Double d -> "Double: " + d;
        case null -> "null";
        default -> "Unknown type";
    };
}
```

### **2. Sealed Classes**
```java
// Java 17 - Sealed classes
public sealed abstract class Shape 
    permits Circle, Rectangle, Triangle {
    
    public abstract double getArea();
}

public final class Circle extends Shape {
    private final double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
```

### **3. Enhanced Pseudo-Random Number Generator**
```java
// Java 17 - PRNG improvements
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomExample {
    public void generateNumbers() {
        // Sử dụng L32X64MixRandom (mặc định)
        RandomGenerator generator = RandomGeneratorFactory.getDefault().create();
        
        // Hoặc chọn algorithm cụ thể
        RandomGenerator lcg = RandomGeneratorFactory.of("L64X128MixRandom").create();
        
        System.out.println(generator.nextInt());
        System.out.println(lcg.nextDouble());
    }
}
```

### **4. Foreign Function & Memory API (Incubator)**
```java
// Java 17 - FFI API (Incubator)
import jdk.incubator.foreign.*;

public class ForeignExample {
    public static void main(String[] args) {
        // Truy cập native memory
        try (MemorySegment segment = MemorySegment.allocateNative(1024)) {
            // Thao tác với native memory
            segment.set(ValueLayout.JAVA_INT, 0, 42);
            int value = segment.get(ValueLayout.JAVA_INT, 0);
        }
    }
}
```

### **5. Vector API (Incubator)**
```java
// Java 17 - Vector API
import jdk.incubator.vector.*;

public class VectorExample {
    public static void vectorAdd(float[] a, float[] b, float[] c) {
        var species = FloatVector.SPECIES_PREFERRED;
        int i = 0;
        
        for (; i < species.loopBound(a.length); i += species.length()) {
            var va = FloatVector.fromArray(species, a, i);
            var vb = FloatVector.fromArray(species, b, i);
            var vc = va.add(vb);
            vc.intoArray(c, i);
        }
        
        // Handle remaining elements
        for (; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
    }
}
```

### **6. Context-Specific Deserialization Filters**
```java
// Java 17 - Deserialization filters
public class DeserializationExample {
    public static void main(String[] args) {
        // Tạo filter cho deserialization
        ObjectInputFilter filter = ObjectInputFilter.Config.createFilter(
            "java.util.HashMap;java.util.ArrayList;!java.util.concurrent.*"
        );
        
        // Áp dụng filter
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        ois.setObjectInputFilter(filter);
    }
}
```

---

## 🔄 So sánh với các ngôn ngữ khác

### **Java vs C++**
| Tính năng | Java | C++ |
|-----------|------|-----|
| Memory Management | Automatic GC | Manual/RAII |
| Pointers | Không có | Có |
| Multiple Inheritance | Interface only | Classes |
| Exception Handling | Checked/Unchecked | Unchecked only |

### **Java vs JavaScript**
| Tính năng | Java | JavaScript |
|-----------|------|------------|
| Typing | Static | Dynamic |
| Memory Management | GC | GC |
| Compilation | Ahead-of-time | Just-in-time |
| Threading | Native | Single-threaded |

### **Java vs Python**
| Tính năng | Java | Python |
|-----------|------|--------|
| Performance | Fast | Slower |
| Memory Usage | Higher | Lower |
| Syntax | Verbose | Concise |
| Ecosystem | Enterprise | General-purpose |

---

## 📊 Performance Characteristics

### **Memory Usage**
```java
// Java memory usage example
public class MemoryUsageExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        System.out.println("Used Memory: " + usedMemory / 1024 / 1024 + " MB");
        System.out.println("Free Memory: " + freeMemory / 1024 / 1024 + " MB");
        System.out.println("Total Memory: " + totalMemory / 1024 / 1024 + " MB");
    }
}
```

### **GC Tuning**
```bash
# JVM options cho performance
-XX:+UseG1GC
-XX:MaxGCPauseMillis=200
-XX:G1HeapRegionSize=16m
-XX:+UseStringDeduplication
```

---

## 🎯 Best Practices

### **1. Memory Management**
```java
// ✅ Good - Sử dụng try-with-resources
try (FileInputStream fis = new FileInputStream("file.txt")) {
    // Process file
}

// ❌ Bad - Không đóng resource
FileInputStream fis = new FileInputStream("file.txt");
// Process file
// fis.close(); // Có thể quên
```

### **2. Exception Handling**
```java
// ✅ Good - Specific exceptions
try {
    // Code that might throw IOException
} catch (IOException e) {
    // Handle IOException specifically
} catch (Exception e) {
    // Handle other exceptions
}

// ❌ Bad - Catch all exceptions
try {
    // Code
} catch (Exception e) {
    // Too broad
}
```

### **3. Resource Management**
```java
// ✅ Good - Use StringBuilder for string concatenation
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append("item").append(i);
}
String result = sb.toString();

// ❌ Bad - String concatenation in loop
String result = "";
for (int i = 0; i < 1000; i++) {
    result += "item" + i; // Creates many temporary objects
}
```

---

## 📚 Tài liệu tham khảo

- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)
- [JEP Index](https://openjdk.java.net/jeps/)
- [Garbage Collection Tuning Guide](https://docs.oracle.com/en/java/javase/17/gctuning/)
- [Java Memory Model](https://docs.oracle.com/javase/specs/jls/se17/html/jls-17.html)

---

*Cập nhật lần cuối: 2024*
