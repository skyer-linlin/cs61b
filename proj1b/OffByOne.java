/**
 * PACKAGE_NAME
 *
 * @author quanlinlin
 * @date 2022/1/19 23:27
 * @since
 */
public class OffByOne implements CharacterComparator{
  @Override
  public boolean equalChars(char x, char y) {
    return (x - y) * (y - x) == -1;
  }
}
