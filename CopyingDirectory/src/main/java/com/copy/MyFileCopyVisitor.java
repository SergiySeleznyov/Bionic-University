package com.copy;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by c263 on 08.07.2015.
 */
public class MyFileCopyVisitor extends SimpleFileVisitor {

    private Path source;
    private Path destination;


    public MyFileCopyVisitor(Path s, Path d) {   //����� ����������� ����� �� ������ ���� �� ����� �� ���� �����������
        source = s;
        destination = d;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        /* ��������� ������ ���������� FileVisitor , �� ���������� ��� ������ �� �����. */
        Path newd = destination.resolve(source.relativize(path));
        try {
            Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        /* ��������� ������ ���������� FileVisitor , �� ���������� ����� �������� �� �������� ��������. */
        Path newd = destination.resolve(source.relativize(path));
        try {
            Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }
}
