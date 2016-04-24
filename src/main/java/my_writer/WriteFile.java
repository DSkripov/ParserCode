package my_writer;

import java.io.*;

/**
 * This is reader class
 */

public class WriteFile implements IWrite {

    private OutputStream fileStream;
    private PrintStream printStream;
    //private InputStream in;
    private Writer fileWriter;
    private PrintWriter printWriter;
    private String path;
    private String name;

    /**
     *
     * @param pathS
     * @throws WriteException
     */
    public WriteFile(String pathS, String nameS) throws WriteException {
        this.name = nameS;
        this.path = pathS;

        try {
            File file = new File(path, name);
            //file.setReadable(true);
            file.setWritable(true);
            this.fileStream = new FileOutputStream(file);
            //this.printStream = new PrintStream(fileStream);
            this.fileWriter = new OutputStreamWriter(fileStream, "utf-8");
            //this.printWriter = new PrintWriter(fileWriter);
        } catch (FileNotFoundException e) {
            throw new WriteException();
        } catch (UnsupportedEncodingException e) {
            throw new WriteException();
        } catch (NullPointerException e) {
            throw new WriteException();
        }

    }

    /**
     *
     * @param str is output string
     * @throws WriteException
     */
    public void write(final String str) throws WriteException {

        //this.fileStream = new FileInputStream(new File(path));
        try {
            this.fileWriter.write(str);
            //this.fileStream.write(str);
        } catch (IOException e) {
            throw new WriteException();
        }
    }

    public void close() throws WriteException {
        try {
            fileWriter.close();
            //fileStream.close();
        } catch (IOException e) {
            throw new WriteException();
        }
    }


}