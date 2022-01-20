/**
 * PACKAGE_NAME
 *
 * @author quanlinlin
 * @date 2022/1/19 23:27
 * @since
 */
public class OffByN implements CharacterComparator {
  private final int N;

  public OffByN(int n) {
    N = n;
  }

  @Override
  public boolean equalChars(char x, char y) {
    return (x - y) * (y - x) == -N * N;
  }
}
