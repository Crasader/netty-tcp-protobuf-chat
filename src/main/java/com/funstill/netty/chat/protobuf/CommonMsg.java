// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CommonMsg.proto

package com.funstill.netty.chat.protobuf;

public final class CommonMsg {
  private CommonMsg() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ContentOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Content)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     **
     *消息类型(1文字,2图片,3音频,4视频,5
     * </pre>
     *
     * <code>uint32 msgType = 1;</code>
     */
    int getMsgType();

    /**
     * <code>uint32 sender = 2;</code>
     */
    int getSender();

    /**
     * <code>uint32 receiver = 3;</code>
     */
    int getReceiver();

    /**
     * <pre>
     **
     *消息内容
     * </pre>
     *
     * <code>string content = 4;</code>
     */
    java.lang.String getContent();
    /**
     * <pre>
     **
     *消息内容
     * </pre>
     *
     * <code>string content = 4;</code>
     */
    com.google.protobuf.ByteString
        getContentBytes();
  }
  /**
   * Protobuf type {@code Content}
   */
  public  static final class Content extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Content)
      ContentOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Content.newBuilder() to construct.
    private Content(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Content() {
      msgType_ = 0;
      sender_ = 0;
      receiver_ = 0;
      content_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Content(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              msgType_ = input.readUInt32();
              break;
            }
            case 16: {

              sender_ = input.readUInt32();
              break;
            }
            case 24: {

              receiver_ = input.readUInt32();
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              content_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.funstill.netty.chat.protobuf.CommonMsg.internal_static_Content_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.funstill.netty.chat.protobuf.CommonMsg.internal_static_Content_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.funstill.netty.chat.protobuf.CommonMsg.Content.class, com.funstill.netty.chat.protobuf.CommonMsg.Content.Builder.class);
    }

    public static final int MSGTYPE_FIELD_NUMBER = 1;
    private int msgType_;
    /**
     * <pre>
     **
     *消息类型(1文字,2图片,3音频,4视频,5
     * </pre>
     *
     * <code>uint32 msgType = 1;</code>
     */
    public int getMsgType() {
      return msgType_;
    }

    public static final int SENDER_FIELD_NUMBER = 2;
    private int sender_;
    /**
     * <code>uint32 sender = 2;</code>
     */
    public int getSender() {
      return sender_;
    }

    public static final int RECEIVER_FIELD_NUMBER = 3;
    private int receiver_;
    /**
     * <code>uint32 receiver = 3;</code>
     */
    public int getReceiver() {
      return receiver_;
    }

    public static final int CONTENT_FIELD_NUMBER = 4;
    private volatile java.lang.Object content_;
    /**
     * <pre>
     **
     *消息内容
     * </pre>
     *
     * <code>string content = 4;</code>
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        content_ = s;
        return s;
      }
    }
    /**
     * <pre>
     **
     *消息内容
     * </pre>
     *
     * <code>string content = 4;</code>
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (msgType_ != 0) {
        output.writeUInt32(1, msgType_);
      }
      if (sender_ != 0) {
        output.writeUInt32(2, sender_);
      }
      if (receiver_ != 0) {
        output.writeUInt32(3, receiver_);
      }
      if (!getContentBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, content_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (msgType_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, msgType_);
      }
      if (sender_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(2, sender_);
      }
      if (receiver_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(3, receiver_);
      }
      if (!getContentBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, content_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.funstill.netty.chat.protobuf.CommonMsg.Content)) {
        return super.equals(obj);
      }
      com.funstill.netty.chat.protobuf.CommonMsg.Content other = (com.funstill.netty.chat.protobuf.CommonMsg.Content) obj;

      boolean result = true;
      result = result && (getMsgType()
          == other.getMsgType());
      result = result && (getSender()
          == other.getSender());
      result = result && (getReceiver()
          == other.getReceiver());
      result = result && getContent()
          .equals(other.getContent());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MSGTYPE_FIELD_NUMBER;
      hash = (53 * hash) + getMsgType();
      hash = (37 * hash) + SENDER_FIELD_NUMBER;
      hash = (53 * hash) + getSender();
      hash = (37 * hash) + RECEIVER_FIELD_NUMBER;
      hash = (53 * hash) + getReceiver();
      hash = (37 * hash) + CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getContent().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.funstill.netty.chat.protobuf.CommonMsg.Content parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.funstill.netty.chat.protobuf.CommonMsg.Content prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Content}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Content)
        com.funstill.netty.chat.protobuf.CommonMsg.ContentOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.funstill.netty.chat.protobuf.CommonMsg.internal_static_Content_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.funstill.netty.chat.protobuf.CommonMsg.internal_static_Content_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.funstill.netty.chat.protobuf.CommonMsg.Content.class, com.funstill.netty.chat.protobuf.CommonMsg.Content.Builder.class);
      }

      // Construct using com.funstill.netty.chat.protobuf.CommonMsg.Content.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        msgType_ = 0;

        sender_ = 0;

        receiver_ = 0;

        content_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.funstill.netty.chat.protobuf.CommonMsg.internal_static_Content_descriptor;
      }

      public com.funstill.netty.chat.protobuf.CommonMsg.Content getDefaultInstanceForType() {
        return com.funstill.netty.chat.protobuf.CommonMsg.Content.getDefaultInstance();
      }

      public com.funstill.netty.chat.protobuf.CommonMsg.Content build() {
        com.funstill.netty.chat.protobuf.CommonMsg.Content result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.funstill.netty.chat.protobuf.CommonMsg.Content buildPartial() {
        com.funstill.netty.chat.protobuf.CommonMsg.Content result = new com.funstill.netty.chat.protobuf.CommonMsg.Content(this);
        result.msgType_ = msgType_;
        result.sender_ = sender_;
        result.receiver_ = receiver_;
        result.content_ = content_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.funstill.netty.chat.protobuf.CommonMsg.Content) {
          return mergeFrom((com.funstill.netty.chat.protobuf.CommonMsg.Content)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.funstill.netty.chat.protobuf.CommonMsg.Content other) {
        if (other == com.funstill.netty.chat.protobuf.CommonMsg.Content.getDefaultInstance()) return this;
        if (other.getMsgType() != 0) {
          setMsgType(other.getMsgType());
        }
        if (other.getSender() != 0) {
          setSender(other.getSender());
        }
        if (other.getReceiver() != 0) {
          setReceiver(other.getReceiver());
        }
        if (!other.getContent().isEmpty()) {
          content_ = other.content_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.funstill.netty.chat.protobuf.CommonMsg.Content parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.funstill.netty.chat.protobuf.CommonMsg.Content) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int msgType_ ;
      /**
       * <pre>
       **
       *消息类型(1文字,2图片,3音频,4视频,5
       * </pre>
       *
       * <code>uint32 msgType = 1;</code>
       */
      public int getMsgType() {
        return msgType_;
      }
      /**
       * <pre>
       **
       *消息类型(1文字,2图片,3音频,4视频,5
       * </pre>
       *
       * <code>uint32 msgType = 1;</code>
       */
      public Builder setMsgType(int value) {
        
        msgType_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       **
       *消息类型(1文字,2图片,3音频,4视频,5
       * </pre>
       *
       * <code>uint32 msgType = 1;</code>
       */
      public Builder clearMsgType() {
        
        msgType_ = 0;
        onChanged();
        return this;
      }

      private int sender_ ;
      /**
       * <code>uint32 sender = 2;</code>
       */
      public int getSender() {
        return sender_;
      }
      /**
       * <code>uint32 sender = 2;</code>
       */
      public Builder setSender(int value) {
        
        sender_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 sender = 2;</code>
       */
      public Builder clearSender() {
        
        sender_ = 0;
        onChanged();
        return this;
      }

      private int receiver_ ;
      /**
       * <code>uint32 receiver = 3;</code>
       */
      public int getReceiver() {
        return receiver_;
      }
      /**
       * <code>uint32 receiver = 3;</code>
       */
      public Builder setReceiver(int value) {
        
        receiver_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 receiver = 3;</code>
       */
      public Builder clearReceiver() {
        
        receiver_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object content_ = "";
      /**
       * <pre>
       **
       *消息内容
       * </pre>
       *
       * <code>string content = 4;</code>
       */
      public java.lang.String getContent() {
        java.lang.Object ref = content_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          content_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       **
       *消息内容
       * </pre>
       *
       * <code>string content = 4;</code>
       */
      public com.google.protobuf.ByteString
          getContentBytes() {
        java.lang.Object ref = content_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          content_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       **
       *消息内容
       * </pre>
       *
       * <code>string content = 4;</code>
       */
      public Builder setContent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       **
       *消息内容
       * </pre>
       *
       * <code>string content = 4;</code>
       */
      public Builder clearContent() {
        
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      /**
       * <pre>
       **
       *消息内容
       * </pre>
       *
       * <code>string content = 4;</code>
       */
      public Builder setContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        content_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Content)
    }

    // @@protoc_insertion_point(class_scope:Content)
    private static final com.funstill.netty.chat.protobuf.CommonMsg.Content DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.funstill.netty.chat.protobuf.CommonMsg.Content();
    }

    public static com.funstill.netty.chat.protobuf.CommonMsg.Content getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Content>
        PARSER = new com.google.protobuf.AbstractParser<Content>() {
      public Content parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Content(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Content> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Content> getParserForType() {
      return PARSER;
    }

    public com.funstill.netty.chat.protobuf.CommonMsg.Content getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Content_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Content_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017CommonMsg.proto\"M\n\007Content\022\017\n\007msgType\030" +
      "\001 \001(\r\022\016\n\006sender\030\002 \001(\r\022\020\n\010receiver\030\003 \001(\r\022" +
      "\017\n\007content\030\004 \001(\tB\"\n com.funstill.netty.c" +
      "hat.protobufb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Content_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Content_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Content_descriptor,
        new java.lang.String[] { "MsgType", "Sender", "Receiver", "Content", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
