package com.sonin.base.builder;

/**
 * @Author sonin
 * @Date 2020/9/29 6:38 下午
 * @Version 1.0
 **/
public class Computer {

    private String cpu;
    private String screen;
    private String memory;

    public Computer() {
        throw new RuntimeException("no init");
    }

    public Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
    }

    public static class Builder {
        private String cpu;
        private String screen;
        private String memory;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Computer builder() {
            return new Computer(this);
        }
    }
}
