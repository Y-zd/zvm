package com.zvm;

import com.google.gson.Gson;
import com.zvm.basestruct.u1;
import com.zvm.draft.Opcode1;
import com.zvm.runtime.JThread;
import com.zvm.runtime.JavaFrame;
import com.zvm.runtime.LocalVars;
import com.zvm.runtime.OperandStack;

public class Interpreter {

    JThread jThread;

    public void invokeByName(JavaClass javaClass, String name, String descriptor){
        method_info method_info = javaClass.findMethod(name, descriptor);
        if (method_info == null){
            return ;
        }
        CallSite callSite = new CallSite();
        callSite.setCallSite( method_info);
        jThread = new JThread();
        jThread.pushFrame(callSite.max_stack, callSite.max_locals);
        executeByteCode(jThread, callSite.code, TypeUtils.byte2Int(callSite.code_length.u4));
    }

    public void executeByteCode(JThread jThread, u1[] codeRaw, int codeLength) {
        JavaFrame javaFrame = jThread.getTopFrame();
        OperandStack operandStack = javaFrame.operandStack;
        LocalVars localVars = javaFrame.localVars;
        CodeUtils code = new CodeUtils(codeRaw, 0);
        for (; code.getPc() < codeLength; code.pcAdd(1)) {
            int opcodeInt = TypeUtils.byte2Int(codeRaw[code.getPc()].u1);
            Gson gson = new Gson();
            System.out.println("pc = " + code.getPc() + " operandStack "+gson.toJson(operandStack));
            System.out.println("pc = " + code.getPc() + " localVars " + gson.toJson(localVars));
            System.out.println();
            System.out.println("pc = " + code.getPc() + " opcode:" + Opcode1.getMnemonic(opcodeInt));


            switch (opcodeInt) {
                case Opcode.nop: {

                }
                break;
                case Opcode.aconst_null: {

                }
                break;
                case Opcode.iconst_m1: {
                }
                break;
                case Opcode.iconst_0: {
                    operandStack.putInt(0);
                }
                break;
                case Opcode.iconst_1: {
                    operandStack.putInt(1);
                }
                break;
                case Opcode.iconst_2: {
                    operandStack.putInt(2);

                }
                break;
                case Opcode.iconst_3: {
                    operandStack.putInt(3);

                }
                break;
                case Opcode.iconst_4: {
                    operandStack.putInt(4);

                }
                break;
                case Opcode.iconst_5: {
                    operandStack.putInt(5);
                }
                break;
                case Opcode.lconst_0: {
                }
                break;
                case Opcode.bipush: {
                    byte byteConstant = code.consumeU1();
                    operandStack.putByte(byteConstant);
                }
                break;
                case Opcode.sipush: {
                }
                break;
                case Opcode.ldc: {
                }
                break;
                case Opcode.ldc_w: {
                }
                break;
                case Opcode.ldc2_w: {
                }
                break;
                case Opcode.iload: {
                }
                break;
                case Opcode.lload: {
                }
                break;
                case Opcode.fload: {
                }
                break;
                case Opcode.dload: {
                }
                break;
                case Opcode.aload: {
                }
                break;
                case Opcode.lload_2: {
                }
                break;
                case Opcode.lload_3: {
                }
                break;
                case Opcode.fload_0: {
                }
                break;
                case Opcode.fload_1: {
                }
                break;
                case Opcode.fload_2: {
                }
                break;
                case Opcode.fload_3: {
                }
                break;
                case Opcode.dload_0: {
                }
                break;
                case Opcode.dload_1: {
                }
                break;
                case Opcode.dload_2: {
                }
                break;
                case Opcode.dload_3: {
                }
                break;
                case Opcode.faload: {
                }
                break;
                case Opcode.daload: {
                }
                break;
                case Opcode.aaload: {
                }
                break;
                case Opcode.baload: {
                }
                break;
                case Opcode.caload: {
                }
                break;
                case Opcode.saload: {
                }
                break;
                case Opcode.istore: {
                }
                break;
                case Opcode.lstore: {
                }
                break;
                case Opcode.fstore: {
                }
                break;
                case Opcode.dstore: {
                }
                break;
                case Opcode.lstore_1: {
                }
                break;
                case Opcode.lstore_2: {
                }
                break;
                case Opcode.lstore_3: {
                }
                break;
                case Opcode.fstore_0: {
                }
                break;
                case Opcode.fstore_1: {
                }
                break;
                case Opcode.fstore_2: {
                }
                break;
                case Opcode.fstore_3: {
                }
                break;
                case Opcode.dstore_0: {
                }
                break;
                case Opcode.dstore_1: {
                }
                break;
                case Opcode.dstore_2: {
                }
                break;
                case Opcode.lastore: {
                }
                break;
                case Opcode.fastore: {
                }
                break;
                case Opcode.dastore: {
                }
                break;
                case Opcode.aastore: {
                }
                break;
                case Opcode.bastore: {
                }
                break;
                case Opcode.castore: {
                }
                break;
                case Opcode.sastore: {
                }
                break;
                case Opcode.pop: {
                }
                break;
                case Opcode.pop2: {
                }
                break;
                case Opcode.dup: {
                }
                break;
                case Opcode.iadd: {
                    int var1 = operandStack.popInt();
                    int var0 = operandStack.popInt();
                    int sum = var0 + var1;
                    operandStack.putInt(sum);
                }
                break;
                case Opcode.ladd: {
                }
                break;
                case Opcode.fadd: {
                }
                break;
                case Opcode.dadd: {
                }
                break;
                case Opcode.isub: {
                }
                break;
                case Opcode.lsub: {
                }
                break;
                case Opcode.fsub: {
                }
                break;
                case Opcode.dsub: {
                }
                break;
                case Opcode.imul: {
                }
                break;
                case Opcode.lmul: {
                }
                break;
                case Opcode.irem: {
                }
                break;
                case Opcode.lrem: {
                }
                break;
                case Opcode.frem: {
                }
                break;
                case Opcode.drem: {
                }
                break;
                case Opcode.ineg: {
                }
                break;
                case Opcode.lneg: {
                }
                break;
                case Opcode.fneg: {
                }
                break;
                case Opcode.dneg: {
                }
                break;
                case Opcode.ishl: {
                }
                break;
                case Opcode.lshl: {
                }
                break;
                case Opcode.ior: {
                }
                break;
                case Opcode.lor: {
                }
                break;
                case Opcode.ixor: {
                }
                break;
                case Opcode.lxor: {
                }
                break;
                case Opcode.iinc: {
                    byte localVarIndex = code.consumeU1();
                    byte constValue = code.consumeU1();
                    int localVar = localVars.getIntByIndex(localVarIndex);
                    localVars.putIntByIndex(localVarIndex, localVar + constValue);
                }
                break;
                case Opcode.i2l: {
                }
                break;
                case Opcode.i2f: {
                }
                break;
                case Opcode.i2d: {
                }
                break;
                case Opcode.l2i: {
                }
                break;
                case Opcode.l2f: {
                }
                break;
                case Opcode.d2f: {
                }
                break;
                case Opcode.i2b: {
                }
                break;
                case Opcode.i2c: {
                }
                break;
                case Opcode.i2s: {
                }
                break;
                case Opcode.lcmp: {
                }
                break;
                case Opcode.fcmpl: {
                }
                break;
                case Opcode.fcmpg: {
                }
                break;
                case Opcode.dcmpl: {
                }
                break;
                case Opcode.dcmpg: {
                }
                break;
                case Opcode.ifeq: {
                }
                break;
                case Opcode.lconst_1: {
                }
                break;
                case Opcode.fconst_0: {
                }
                break;
                case Opcode.fconst_1: {
                }
                break;
                case Opcode.fconst_2: {
                }
                break;
                case Opcode.dconst_0: {
                }
                break;
                case Opcode.dconst_1: {
                }
                break;
                case Opcode.iload_0: {
                    operandStack.putInt(localVars.getIntByIndex(0));
                }
                break;
                case Opcode.iload_1: {
                    operandStack.putInt(localVars.getIntByIndex(1));
                }
                break;
                case Opcode.iload_2: {
                    operandStack.putInt(localVars.getIntByIndex(2));
                }
                break;
                case Opcode.iload_3: {
                    operandStack.putInt(localVars.getIntByIndex(3));
                }
                break;
                case Opcode.lload_0: {
                }
                break;
                case Opcode.lload_1: {
                }
                break;
                case Opcode.aload_0: {
                }
                break;
                case Opcode.aload_1: {
                }
                break;
                case Opcode.aload_2: {
                }
                break;
                case Opcode.aload_3: {
                }
                break;
                case Opcode.iaload: {
                }
                break;
                case Opcode.laload: {
                }
                break;
                case Opcode.astore: {
                }
                break;
                case Opcode.istore_0: {
                    localVars.putIntByIndex(0, operandStack.popInt());
                }
                break;
                case Opcode.istore_1: {
                    localVars.putIntByIndex(1, operandStack.popInt());
                }
                break;
                case Opcode.istore_2: {
                    localVars.putIntByIndex(2, operandStack.popInt());
                }
                break;
                case Opcode.istore_3: {

                }
                break;
                case Opcode.lstore_0: {
                }
                break;
                case Opcode.dstore_3: {
                }
                break;
                case Opcode.astore_0: {
                }
                break;
                case Opcode.astore_1: {
                }
                break;
                case Opcode.astore_2: {
                }
                break;
                case Opcode.astore_3: {
                }
                break;
                case Opcode.iastore: {
                }
                break;
                case Opcode.dup_x1: {
                }
                break;
                case Opcode.dup_x2: {
                }
                break;
                case Opcode.dup2: {
                }
                break;
                case Opcode.dup2_x1: {
                }
                break;
                case Opcode.dup2_x2: {
                }
                break;
                case Opcode.swap: {
                }
                break;
                case Opcode.fmul: {
                }
                break;
                case Opcode.dmul: {
                }
                break;
                case Opcode.idiv: {
                }
                break;
                case Opcode.ldiv: {
                }
                break;
                case Opcode.fdiv: {
                }
                break;
                case Opcode.ddiv: {
                }
                break;
                case Opcode.ishr: {
                }
                break;
                case Opcode.lshr: {
                }
                break;
                case Opcode.iushr: {
                }
                break;
                case Opcode.lushr: {
                }
                break;
                case Opcode.iand: {
                }
                break;
                case Opcode.land: {
                }
                break;
                case Opcode.l2d: {
                }
                break;
                case Opcode.f2i: {
                }
                break;
                case Opcode.f2l: {
                }
                break;
                case Opcode.f2d: {
                }
                break;
                case Opcode.d2i: {
                }
                break;
                case Opcode.d2l: {
                }
                break;
                case Opcode.ifne: {
                }
                break;
                case Opcode.iflt: {
                }
                break;
                case Opcode.ifge: {
                }
                break;
                case Opcode.ifgt: {
                }
                break;
                case Opcode.ifle: {
                }
                break;
                case Opcode.if_icmpeq: {
                }
                break;
                case Opcode.if_icmpne: {
                }
                break;
                case Opcode.if_icmplt: {
                }
                break;
                case Opcode.if_icmpge: {
                }
                break;
                case Opcode.if_icmpgt: {
                    int var1 = operandStack.popInt();
                    int var0 = operandStack.popInt();
                    short offset = code.readU2();
                    if(var0 >= var1){
                        /*分支*/
                        code.pcAdd(offset);
                    }else {
                        code.pcAdd(2);
                    }
                }
                break;
                case Opcode.if_icmple: {
                }
                break;
                case Opcode.if_acmpeq: {
                }
                break;
                case Opcode.if_acmpne: {
                }
                break;
                case Opcode.goto_: {
                    short offset = code.readU2();
                    code.pcAdd(offset - 1);/*循环默认加 1，这里先减回来*/
                }
                break;
                case Opcode.jsr: {
                }
                break;
                case Opcode.ret: {
                }
                break;
                case Opcode.tableswitch: {
                }
                break;
                case Opcode.lookupswitch: {
                }
                break;
                case Opcode.ireturn: {
                }
                break;
                case Opcode.lreturn: {
                }
                break;
                case Opcode.freturn: {
                }
                break;
                case Opcode.dreturn: {
                }
                break;
                case Opcode.areturn: {
                }
                break;
                case Opcode.return_: {
                }
                break;
                case Opcode.getstatic: {
                }
                break;
                case Opcode.putstatic: {
                }
                break;
                case Opcode.getfield: {
                }
                break;
                case Opcode.putfield: {
                }
                break;
                case Opcode.invokevirtual: {
                }
                break;
                case Opcode.invokespecial: {
                }
                break;
                case Opcode.invokestatic: {
                }
                break;
                case Opcode.invokeinterface: {
                }
                break;
                case Opcode.xxxunusedxxx: {
                }
                break;
                case Opcode.new_: {
                }
                break;
                case Opcode.newarray: {
                }
                break;
                case Opcode.anewarray: {
                }
                break;
                case Opcode.arraylength: {
                }
                break;
                case Opcode.athrow: {
                }
                break;
                case Opcode.checkcast: {
                }
                break;
                case Opcode.instanceof_: {
                }
                break;
                case Opcode.monitorenter: {
                }
                break;
                case Opcode.monitorexit: {
                }
                break;
                case Opcode.wide: {
                }
                break;
                case Opcode.multianewarray: {
                }
                break;
                case Opcode.ifnull: {
                }
                break;
                case Opcode.ifnonnull: {
                }
                break;
                case Opcode.goto_w: {
                }
                break;
                case Opcode.jsr_w: {
                }
                break;
                case Opcode.breakpoint: {
                }
                break;
                case Opcode.impdep1: {
                }
                break;
                case Opcode.impdep2: {
                }
                break;
            }
        }
    }

}